package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.ConvertsOffsetDateTime
import java.time.OffsetDateTime

/**
 * A simple encoder for {@link java.time.OffsetDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetDateTimeEncoder implements SimpleEncoder.TypeEncoder, ConvertsOffsetDateTime {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (OffsetDateTime)value)
    }
}