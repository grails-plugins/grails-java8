package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset

/**
 * A trait to read and write a {@link LocalDate} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsLocalDate implements ConvertsTemporal<LocalDate> {

    @Override
    void write(BsonWriter writer, LocalDate value) {
        LocalDateTime localDateTime = LocalDateTime.of(value, LocalTime.MIN)
        writer.writeDateTime(localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli())
    }

    @Override
    LocalDate read(BsonReader reader) {
        Instant instant = Instant.ofEpochMilli(reader.readDateTime())
        LocalDateTime.ofInstant(instant, ZoneId.of('UTC')).toLocalDate()
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}