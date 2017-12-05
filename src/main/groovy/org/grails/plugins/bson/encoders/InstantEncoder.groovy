package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import static org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.InstantBsonConverter

import java.time.Instant

/**
 * A simple encoder for {@link java.time.Instant}
 *
 * @author James Kleeh
 */
@CompileStatic
class InstantEncoder implements TypeEncoder, InstantBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (Instant)value)
    }
}