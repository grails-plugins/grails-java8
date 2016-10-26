package org.grails.plugins.json.converters

import grails.plugin.json.builder.JsonConverter
import grails.plugin.json.builder.JsonOutput
import groovy.transform.CompileStatic

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

/**
 * A class to render a {@link OffsetDateTime} as json
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetDateTimeJsonConverter implements JsonConverter {

    @Override
    Closure<? extends CharSequence> getConverter() {
        { OffsetDateTime offsetDateTime ->
            JsonOutput.toJson(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime))
        }
    }

    @Override
    Class getType() {
        OffsetDateTime
    }
}
