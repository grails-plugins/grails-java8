package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.LocalTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.LocalTime

/**
 * A class to implement {@link Converter} for {@link java.time.LocalTime} to Long
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalTimeToLongConverter implements Converter<LocalTime, Long>, LocalTimeConverter {
}
