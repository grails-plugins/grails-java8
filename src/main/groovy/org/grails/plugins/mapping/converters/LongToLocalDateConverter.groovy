package org.grails.plugins.mapping.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.LocalDateConverter
import org.springframework.core.convert.converter.Converter
import java.time.LocalDate

/**
 * A class to implement {@link Converter} for Long to {@link java.time.LocalDate}
 *
 * @author James Kleeh
 */
@CompileStatic
class LongToLocalDateConverter implements Converter<Long, LocalDate>, LocalDateConverter {
}
