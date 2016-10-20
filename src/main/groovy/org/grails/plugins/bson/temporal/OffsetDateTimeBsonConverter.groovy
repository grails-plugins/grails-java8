package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import org.grails.plugins.converters.OffsetDateTimeConverter

import java.time.Instant
import java.time.OffsetDateTime

/**
 * A trait to read and write a {@link OffsetDateTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait OffsetDateTimeBsonConverter implements TemporalBsonConverter<OffsetDateTime>, OffsetDateTimeConverter {

    @Override
    void write(BsonWriter writer, OffsetDateTime value) {
        writer.writeDateTime(convert(value))
    }

    @Override
    OffsetDateTime read(BsonReader reader) {
        convert(reader.readDateTime())
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}
