package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.springframework.core.convert.converter.Converter
import java.time.Period

/**
 * A class to implement {@link Converter} for String to {@link java.time.Period}
 *
 * @author James Kleeh
 */
@CompileStatic
class StringToPeriodConverter implements Converter<String, Period>, PeriodConverter {
}
