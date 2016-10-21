package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import static org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.ZonedDateTimeBsonConverter
import java.time.ZonedDateTime

/**
 * A simple encoder for {@link java.time.ZonedDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class ZonedDateTimeEncoder implements TypeEncoder, ZonedDateTimeBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (ZonedDateTime)value)
    }
}