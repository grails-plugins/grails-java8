package org.grails.plugins.mapping.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.OffsetDateTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.OffsetDateTime

/**
 * A class to implement {@link Converter} for Long to {@link java.time.OffsetDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LongToOffsetDateTimeConverter implements Converter<Long, OffsetDateTime>, OffsetDateTimeConverter {
}
