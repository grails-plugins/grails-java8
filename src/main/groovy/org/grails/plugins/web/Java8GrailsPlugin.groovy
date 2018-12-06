package org.grails.plugins.web

import grails.config.Settings
import grails.plugins.*
import org.grails.datastore.gorm.neo4j.Neo4jMappingContext
import org.grails.datastore.mapping.reflect.ClassUtils
import org.grails.plugins.bson.CodecRegistry
import org.grails.plugins.converters.InstantToLongConverter
import org.grails.plugins.converters.LocalDateTimeToLongConverter
import org.grails.plugins.converters.LocalDateToLongConverter
import org.grails.plugins.converters.LocalTimeToLongConverter
import org.grails.plugins.converters.LongToInstantConverter
import org.grails.plugins.converters.LongToLocalDateConverter
import org.grails.plugins.converters.LongToLocalDateTimeConverter
import org.grails.plugins.converters.LongToLocalTimeConverter
import org.grails.plugins.converters.LongToOffsetDateTimeConverter
import org.grails.plugins.converters.LongToOffsetTimeConverter
import org.grails.plugins.converters.LongToZonedDateTimeConverter
import org.grails.plugins.converters.OffsetDateTimeToLongConverter
import org.grails.plugins.converters.OffsetTimeToLongConverter
import org.grails.plugins.converters.PeriodToStringConverter
import org.grails.plugins.converters.StringToPeriodConverter
import org.grails.plugins.converters.ZonedDateTimeToLongConverter
import org.grails.plugins.databinding.DataBindingGrailsPlugin
import org.grails.plugins.mapping.converters.*

import java.lang.reflect.Field

class Java8GrailsPlugin extends Plugin {

    public static final String DEFAULT_JSR310_OFFSET_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"
    public static final String DEFAULT_JSR310_OFFSET_TIME_FORMAT = "HH:mm:ssZ"
    public static final String DEFAULT_JSR310_LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    public static final String DEFAULT_JSR310_LOCAL_DATE_FORMAT = "yyyy-MM-dd"
    public static final String DEFAULT_JSR310_LOCAL_TIME_FORMAT = "HH:mm:ss"
    public static final String DEFAULT_JSR310_ZONED_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"

    /**
     * Default JSR310 Date formats. Used when no custom formats are supplied.
     *
     * Note: the JSR310 formats extend the defaults provided in {@link DataBindingGrailsPlugin#DEFAULT_DATE_FORMATS}
     *
     * Note 2: currently {@link #DEFAULT_JSR310_OFFSET_DATE_TIME_FORMAT} == {@link #DEFAULT_JSR310_ZONED_DATE_TIME_FORMAT},
     *         but both are included for completeness/documentation, or in case either format changes.
     */
    public static final Set<String> DEFAULT_JSR310_FORMATS = [
            DEFAULT_JSR310_OFFSET_DATE_TIME_FORMAT,
            DEFAULT_JSR310_OFFSET_TIME_FORMAT,
            DEFAULT_JSR310_LOCAL_DATE_TIME_FORMAT,
            DEFAULT_JSR310_LOCAL_DATE_FORMAT,
            DEFAULT_JSR310_LOCAL_TIME_FORMAT,
            DEFAULT_JSR310_ZONED_DATE_TIME_FORMAT
    ] + DataBindingGrailsPlugin.DEFAULT_DATE_FORMATS

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.2.1 > *"

    // TODO Fill in these fields
    def title = "Grails Java 8 Plugin" // Headline output name of the plugin
    def author = "James Kleeh"
    def authorEmail = "kleehj@ociweb.com"
    def description = '''\
This plugin provides support for Java 8 specific functions in a Grails application
'''
    String documentation = ''
    String license = 'APACHE'
    def organization = [name: 'Grails', url: 'http://www.grails.org/']
    def issueManagement = [url: 'https://github.com/grails-plugins/grails-java8/issues']
    def scm = [url: 'https://github.com/grails-plugins/grails-java8']
    def loadAfter = ['groovyPages']

    Closure doWithSpring() {{->

        Set<String> dateFormats = getDateFormats()

        if (ClassUtils.isPresent('org.grails.plugins.web.GrailsTagDateHelper')) {
            grailsTagDateHelper(Jsr310TagDateHelper)
        }

        jsr310DataBinding(Jsr310ConvertersConfiguration) {
            formatStrings = dateFormats
        }

        if (ClassUtils.isPresent('org.grails.datastore.bson.codecs.PropertyEncoder')) {
            CodecRegistry.registerDecoders()
            CodecRegistry.registerEncoders()
        }

    }}

    /**
     * Get the configured date formats.
     *
     * Tries to:
     *  1. Load any configured date formats
     *  2. Falls back to the {@link #DEFAULT_JSR310_FORMATS} for sensible defaults
     *
     * @return a set of formats to use when binding dates via {@link Jsr310ConvertersConfiguration}
     */
    Set<String> getDateFormats() {
        Field formats
        try {
            formats = DataBindingGrailsPlugin.getDeclaredField('DATE_FORMATS')
        } catch (NoSuchFieldException e) {
            formats = Settings.getDeclaredField('DATE_FORMATS')
        }
        String dateFormatProperty = formats.get(null)

        return config.getProperty(dateFormatProperty, Set, DEFAULT_JSR310_FORMATS)
    }

    @Override
    void doWithApplicationContext() {
        if (ClassUtils.isPresent('org.grails.datastore.gorm.neo4j.Neo4jMappingContext')) {
            Neo4jMappingContext mappingContext = applicationContext.getBean(Neo4jMappingContext)

            mappingContext.addTypeConverter(new LongToLocalDateConverter())
            mappingContext.addTypeConverter(new LongToLocalDateTimeConverter())
            mappingContext.addTypeConverter(new LongToLocalTimeConverter())
            mappingContext.addTypeConverter(new LongToOffsetDateTimeConverter())
            mappingContext.addTypeConverter(new LongToOffsetTimeConverter())
            mappingContext.addTypeConverter(new LongToZonedDateTimeConverter())
            mappingContext.addTypeConverter(new StringToPeriodConverter())
            mappingContext.addTypeConverter(new LongToInstantConverter())

            mappingContext.addTypeConverter(new LocalDateToLongConverter())
            mappingContext.addTypeConverter(new LocalDateTimeToLongConverter())
            mappingContext.addTypeConverter(new LocalTimeToLongConverter())
            mappingContext.addTypeConverter(new OffsetDateTimeToLongConverter())
            mappingContext.addTypeConverter(new OffsetTimeToLongConverter())
            mappingContext.addTypeConverter(new ZonedDateTimeToLongConverter())
            mappingContext.addTypeConverter(new PeriodToStringConverter())
            mappingContext.addTypeConverter(new InstantToLongConverter())
        }
    }

}
