package org.grails.plugins.json.converters

import grails.plugin.json.builder.JsonConverter
import grails.plugin.json.builder.JsonOutput
import groovy.transform.CompileStatic

import java.time.OffsetTime
import java.time.format.DateTimeFormatter

/**
 * A class to render a {@link OffsetTime} as json
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetTimeJsonConverter implements JsonConverter {

    @Override
    Closure<? extends CharSequence> getConverter() {
        { OffsetTime offsetTime ->
            JsonOutput.toJson(DateTimeFormatter.ISO_OFFSET_TIME.format(offsetTime))
        }
    }

    @Override
    Class getType() {
        OffsetTime
    }
}
