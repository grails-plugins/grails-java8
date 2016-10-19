package org.grails.plugins.bson.temporal

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter

import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset

/**
 * A trait to read and write a {@link java.time.temporal.Temporal} to MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
trait ConvertsTemporal<T> {

    abstract void write(BsonWriter writer, T value)

    abstract T read(BsonReader reader)

    abstract BsonType bsonType()

    ZoneOffset getSystemOffset() {
        Instant instant = Instant.now()
        ZoneId systemZone = ZoneId.systemDefault()
        systemZone.rules.getOffset(instant)
    }
}