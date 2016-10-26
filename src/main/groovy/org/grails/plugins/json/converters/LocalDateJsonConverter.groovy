package org.grails.plugins.json.converters

import grails.plugin.json.builder.JsonConverter
import grails.plugin.json.builder.JsonOutput
import groovy.transform.CompileStatic

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * A class to render a {@link LocalDate} as json
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateJsonConverter implements JsonConverter {

    @Override
    Closure<? extends CharSequence> getConverter() {
        { LocalDate localDate ->
            JsonOutput.toJson(DateTimeFormatter.ISO_LOCAL_DATE.format(localDate))
        }
    }

    @Override
    Class getType() {
        LocalDate
    }
}
