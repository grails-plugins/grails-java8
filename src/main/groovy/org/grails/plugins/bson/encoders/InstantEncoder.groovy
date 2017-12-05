package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.InstantBsonConverter

import java.time.Instant

/**
 * A simple encoder for {@link java.time.Instant}
 *
 * @author James Kleeh
 */
@CompileStatic
class InstantEncoder implements SimpleEncoder.TypeEncoder, InstantBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (Instant)value)
    }
}