package org.grails.plugins.converters

import groovy.transform.CompileStatic
import org.springframework.core.convert.converter.Converter

import java.time.Instant

/**
 * A class to implement {@link Converter} for Long to {@link java.time.Instant}
 *
 * @author James Kleeh
 */
@CompileStatic
class LongToInstantConverter implements Converter<Long, Instant>, InstantConverter {
}
