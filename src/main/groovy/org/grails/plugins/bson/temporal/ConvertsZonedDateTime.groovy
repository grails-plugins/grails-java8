package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import java.time.Instant
import java.time.ZonedDateTime

/**
 * A trait to read and write a {@link ZonedDateTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsZonedDateTime implements ConvertsTemporal<ZonedDateTime> {

    @Override
    void write(BsonWriter writer, ZonedDateTime value) {
        writer.writeDateTime(value.toInstant().toEpochMilli())
    }

    @Override
    ZonedDateTime read(BsonReader reader) {
        ZonedDateTime.ofInstant(Instant.ofEpochMilli(reader.readDateTime()), systemOffset)
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}
