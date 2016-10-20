package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.OffsetDateTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.OffsetDateTime

/**
 * A class to implement {@link Converter} for {@link java.time.OffsetDateTime} to Long
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetDateTimeToLongConverter implements Converter<OffsetDateTime, Long>, OffsetDateTimeConverter {
}
