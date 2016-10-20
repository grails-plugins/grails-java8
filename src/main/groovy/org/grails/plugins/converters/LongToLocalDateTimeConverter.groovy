package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.LocalDateTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.LocalDateTime

/**
 * A class to implement {@link Converter} for Long to {@link java.time.LocalDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LongToLocalDateTimeConverter implements Converter<Long, LocalDateTime>, LocalDateTimeConverter {
}

