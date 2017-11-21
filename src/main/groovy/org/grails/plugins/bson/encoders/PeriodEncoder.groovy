package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder.TypeEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.PeriodBsonConverter
import java.time.Period

/**
 * A simple encoder for {@link java.time.Period}
 *
 * @author James Kleeh
 */
@CompileStatic
class PeriodEncoder implements TypeEncoder, PeriodBsonConverter {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (Period)value)
    }
}