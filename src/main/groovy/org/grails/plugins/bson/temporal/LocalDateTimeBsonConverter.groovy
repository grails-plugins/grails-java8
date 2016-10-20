package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import org.grails.plugins.converters.LocalDateTimeConverter

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

/**
 * A trait to read and write a {@link LocalDateTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait LocalDateTimeBsonConverter implements TemporalBsonConverter<LocalDateTime>, LocalDateTimeConverter {

    @Override
    void write(BsonWriter writer, LocalDateTime value) {
        writer.writeDateTime(convert(value))
    }

    @Override
    LocalDateTime read(BsonReader reader) {
        convert(reader.readDateTime())
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}