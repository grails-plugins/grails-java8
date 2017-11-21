package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.springframework.core.convert.converter.Converter
import java.time.Period

/**
 * A class to implement {@link Converter} for {@link java.time.Period} to String
 *
 * @author James Kleeh
 */
@CompileStatic
class PeriodToStringConverter implements Converter<Period, String>, PeriodConverter {
}
