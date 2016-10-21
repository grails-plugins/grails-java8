package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import static org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.LocalTimeBsonConverter
import java.time.LocalTime

/**
 * A simple encoder for {@link java.time.LocalTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalTimeEncoder implements TypeEncoder, LocalTimeBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (LocalTime)value)
    }
}