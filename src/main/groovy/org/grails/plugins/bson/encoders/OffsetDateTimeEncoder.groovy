package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import static org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.OffsetDateTimeBsonConverter
import java.time.OffsetDateTime

/**
 * A simple encoder for {@link java.time.OffsetDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetDateTimeEncoder implements TypeEncoder, OffsetDateTimeBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (OffsetDateTime)value)
    }
}