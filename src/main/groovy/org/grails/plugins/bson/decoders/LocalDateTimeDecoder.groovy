package org.grails.plugins.bson.decoders

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.grails.datastore.bson.codecs.decoders.SimpleDecoder
import org.grails.datastore.mapping.engine.EntityAccess
import org.grails.datastore.mapping.model.PersistentProperty
import org.grails.plugins.bson.temporal.LocalDateTimeBsonConverter

/**
 * A simple decoder for {@link java.time.LocalDateTime}
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateTimeDecoder implements SimpleDecoder.TypeDecoder, LocalDateTimeBsonConverter {

    @Override
    void decode(BsonReader reader, PersistentProperty property, EntityAccess entityAccess) {
        entityAccess.setPropertyNoConversion(property.name, read(reader))
    }
}
