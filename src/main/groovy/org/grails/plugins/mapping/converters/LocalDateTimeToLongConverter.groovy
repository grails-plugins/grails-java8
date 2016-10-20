package org.grails.plugins.mapping.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.LocalDateTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.LocalDateTime

/**
 * A class to implement {@link Converter} for {@link LocalDateTime} to Long
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateTimeToLongConverter implements Converter<LocalDateTime, Long>, LocalDateTimeConverter {
}
