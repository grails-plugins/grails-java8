package org.grails.plugins.bson.codecs

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.grails.plugins.bson.temporal.ConvertsOffsetDateTime
import java.time.*

/**
 * A class to translate a {@link OffsetDateTime} in MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetDateTimeCodec implements Codec<OffsetDateTime>, ConvertsOffsetDateTime {

    @Override
    OffsetDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        read(reader)
    }

    @Override
    void encode(BsonWriter writer, OffsetDateTime value, EncoderContext encoderContext) {
        write(writer, value)
    }

    @Override
    Class<OffsetDateTime> getEncoderClass() { OffsetDateTime }
}
