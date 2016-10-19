package org.grails.plugins.bson.encoders

import groovy.transform.CompileStatic
import org.bson.BsonWriter
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.ConvertsLocalDate
import java.time.LocalDate

/**
 * A simple encoder for {@link LocalDate}
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateEncoder implements SimpleEncoder.TypeEncoder, ConvertsLocalDate {

    @Override
    void encode(BsonWriter writer, PersistentProperty property, Object value) {
        write(writer, (LocalDate)value)
    }
}
