package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.ConvertsLocalTime
import java.time.LocalTime

/**
 * A simple encoder for {@link java.time.LocalTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalTimeEncoder implements SimpleEncoder.TypeEncoder, ConvertsLocalTime {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (LocalTime)value)
    }
}