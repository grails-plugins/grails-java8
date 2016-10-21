package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import static org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.LocalDateTimeBsonConverter
import java.time.LocalDateTime

/**
 * A simple encoder for {@link java.time.LocalDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateTimeEncoder implements TypeEncoder, LocalDateTimeBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (LocalDateTime)value)
    }
}