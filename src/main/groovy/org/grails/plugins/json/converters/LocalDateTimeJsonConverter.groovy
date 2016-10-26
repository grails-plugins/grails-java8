package org.grails.plugins.json.converters

import grails.plugin.json.builder.JsonConverter
import grails.plugin.json.builder.JsonOutput
import groovy.transform.CompileStatic

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * A class to render a {@link LocalDateTime} as json
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateTimeJsonConverter implements JsonConverter {

    @Override
    Closure<? extends CharSequence> getConverter() {
        { LocalDateTime localDateTime ->
            JsonOutput.toJson(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime))
        }
    }

    @Override
    Class getType() {
        LocalDateTime
    }
}
