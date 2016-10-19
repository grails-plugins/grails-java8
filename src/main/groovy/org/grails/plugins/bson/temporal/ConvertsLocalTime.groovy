package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import java.time.LocalTime

/**
 * A trait to read and write a {@link LocalTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsLocalTime implements ConvertsTemporal<LocalTime> {

    @Override
    void write(BsonWriter writer, LocalTime value) {
        writer.writeInt64(value.toNanoOfDay())
    }

    @Override
    LocalTime read(BsonReader reader) {
        LocalTime.ofNanoOfDay(reader.readInt64())
    }

    @Override
    BsonType bsonType() {
        BsonType.INT64
    }
}