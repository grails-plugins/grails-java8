package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.ConvertsLocalDateTime
import java.time.LocalDateTime

/**
 * A simple encoder for {@link java.time.LocalDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateTimeEncoder implements SimpleEncoder.TypeEncoder, ConvertsLocalDateTime {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (LocalDateTime)value)
    }
}