package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.OffsetTimeBsonConverter
import java.time.OffsetTime

/**
 * A simple encoder for {@link java.time.OffsetTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetTimeEncoder implements SimpleEncoder.TypeEncoder, OffsetTimeBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (OffsetTime)value)
    }
}