package org.grails.plugins.json.converters

import grails.plugin.json.builder.JsonConverter
import grails.plugin.json.builder.JsonOutput
import groovy.transform.CompileStatic

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * A class to render a {@link ZonedDateTime} as json
 *
 * @author James Kleeh
 */
@CompileStatic
class ZonedDateTimeJsonConverter implements JsonConverter {

    @Override
    Closure<? extends CharSequence> getConverter() {
        { ZonedDateTime zonedDateTime ->
            JsonOutput.toJson(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDateTime))
        }
    }

    @Override
    Class getType() {
        ZonedDateTime
    }
}
