package org.grails.plugins.mapping.converters

import groovy.transform.CompileStatic
import org.grails.plugins.converters.LocalTimeConverter
import org.springframework.core.convert.converter.Converter
import java.time.LocalTime

/**
 * A class to implement {@link Converter} for Long to {@link java.time.LocalTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LongToLocalTimeConverter implements Converter<Long, LocalTime>, LocalTimeConverter{
}
