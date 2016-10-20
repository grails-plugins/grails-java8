package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.LocalDateConverter
import org.springframework.core.convert.converter.Converter
import java.time.LocalDate

/**
 * A class to implement {@link Converter} for {@link java.time.LocalDate} to Long
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateToLongConverter implements Converter<LocalDate, Long>, LocalDateConverter {
}
