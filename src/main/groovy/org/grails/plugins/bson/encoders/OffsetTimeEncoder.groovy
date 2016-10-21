package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import static org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.OffsetTimeBsonConverter
import java.time.OffsetTime

/**
 * A simple encoder for {@link java.time.OffsetTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetTimeEncoder implements TypeEncoder, OffsetTimeBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (OffsetTime)value)
    }
}