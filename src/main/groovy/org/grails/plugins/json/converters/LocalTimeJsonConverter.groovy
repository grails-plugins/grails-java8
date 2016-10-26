package org.grails.plugins.json.converters

import grails.plugin.json.builder.JsonConverter
import grails.plugin.json.builder.JsonOutput
import groovy.transform.CompileStatic

import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * A class to render a {@link LocalTime} as json
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalTimeJsonConverter implements JsonConverter {

    @Override
    Closure<? extends CharSequence> getConverter() {
        { LocalTime localTime ->
            JsonOutput.toJson(DateTimeFormatter.ISO_LOCAL_TIME.format(localTime))
        }
    }

    @Override
    Class getType() {
        LocalTime
    }
}
