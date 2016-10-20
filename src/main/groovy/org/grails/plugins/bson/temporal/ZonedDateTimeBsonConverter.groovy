package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import org.grails.plugins.converters.ZonedDateTimeConverter

import java.time.Instant
import java.time.ZonedDateTime

/**
 * A trait to read and write a {@link ZonedDateTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ZonedDateTimeBsonConverter implements TemporalBsonConverter<ZonedDateTime>, ZonedDateTimeConverter {

    @Override
    void write(BsonWriter writer, ZonedDateTime value) {
        writer.writeDateTime(convert(value))
    }

    @Override
    ZonedDateTime read(BsonReader reader) {
        convert(reader.readDateTime())
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}
