package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import java.time.Instant
import java.time.OffsetDateTime

/**
 * A trait to read and write a {@link OffsetDateTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsOffsetDateTime implements ConvertsTemporal<OffsetDateTime> {

    @Override
    void write(BsonWriter writer, OffsetDateTime value) {
        writer.writeDateTime(value.toInstant().toEpochMilli())
    }

    @Override
    OffsetDateTime read(BsonReader reader) {
        OffsetDateTime.ofInstant(Instant.ofEpochMilli(reader.readDateTime()), systemOffset)
    }

    @Override
    BsonType bsonType() {
        BsonType.DATE_TIME
    }
}
