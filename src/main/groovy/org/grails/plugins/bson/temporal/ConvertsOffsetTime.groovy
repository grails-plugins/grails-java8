package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import java.time.OffsetTime

/**
 * A trait to read and write a {@link OffsetTime} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsOffsetTime implements ConvertsTemporal<OffsetTime> {

    @Override
    void write(BsonWriter writer, OffsetTime value) {
        writer.writeString(value.toString())
    }

    @Override
    OffsetTime read(BsonReader reader) {
        OffsetTime.parse(reader.readString()).withOffsetSameInstant(systemOffset)
    }

    @Override
    BsonType bsonType() {
        BsonType.STRING
    }
}