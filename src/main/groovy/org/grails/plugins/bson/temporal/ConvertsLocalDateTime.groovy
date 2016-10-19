package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
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
trait ConvertsLocalDateTime implements ConvertsTemporal<LocalDateTime> {

    @Override
    void write(BsonWriter writer, LocalDateTime value) {
        writer.writeDateTime(value.toInstant(ZoneOffset.UTC).toEpochMilli())
    }

    @Override
    LocalDateTime read(BsonReader reader) {
        LocalDateTime.ofInstant(Instant.ofEpochMilli(reader.readDateTime()), ZoneId.of('UTC'))
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}