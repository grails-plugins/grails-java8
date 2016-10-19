package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import java.time.LocalDate

/**
 * A trait to read and write a {@link LocalDate} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsLocalDate implements ConvertsTemporal<LocalDate> {

    @Override
    void write(BsonWriter writer, LocalDate value) {
        writer.writeInt64(value.toEpochDay())
    }

    @Override
    LocalDate read(BsonReader reader) {
        LocalDate.ofEpochDay(reader.readInt64())
    }

    @Override
    BsonType bsonType() {
        BsonType.INT64
    }
}