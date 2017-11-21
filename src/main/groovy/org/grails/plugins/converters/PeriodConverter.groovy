package org.grails.plugins.converters

import groovy.transform.CompileStatic

import java.time.Period

@CompileStatic
trait PeriodConverter {

    String convert(Period value) {
        value.toString()
    }

    Period convert(String value) {
        Period.parse(value)
    }
}
