package org.grails.plugins.bson.codecs

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.grails.plugins.bson.temporal.ConvertsLocalDateTime
import java.time.*

/**
 * A class to translate a {@link LocalDateTime} in MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
class LocalDateTimeCodec implements Codec<LocalDateTime>, ConvertsLocalDateTime {

    @Override
    LocalDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        return read(reader)
    }

    @Override
    void encode(BsonWriter writer, LocalDateTime value, EncoderContext encoderContext) {
        write(writer, value)
    }

    @Override
    Class<LocalDateTime> getEncoderClass() { LocalDateTime }
}
