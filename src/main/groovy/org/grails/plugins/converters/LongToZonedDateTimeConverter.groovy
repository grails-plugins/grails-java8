package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.ZonedDateTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.ZonedDateTime

/**
 * A class to implement {@link Converter} for Long to {@link java.time.ZonedDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LongToZonedDateTimeConverter implements Converter<Long, ZonedDateTime>, ZonedDateTimeConverter {
}
