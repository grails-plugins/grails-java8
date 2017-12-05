package org.grails.plugins.converters

import groovy.transform.CompileStatic

import java.time.Period

/**
 * A trait to convert a {@link java.time.Period} to and from a String
 *
 * @author James Kleeh
 */
@CompileStatic
trait PeriodConverter {

    String convert(Period value) {
        value.toString()
    }

    Period convert(String value) {
        Period.parse(value)
    }
}
