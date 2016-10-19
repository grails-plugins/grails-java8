package org.grails.plugins.bson.codecs

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.grails.plugins.bson.temporal.ConvertsOffsetTime
import java.time.*

/**
 * A class to translate a {@link OffsetTime} in MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
class OffsetTimeCodec implements Codec<OffsetTime>, ConvertsOffsetTime {

    @Override
    OffsetTime decode(BsonReader reader, DecoderContext decoderContext) {
        read(reader)
    }

    @Override
    void encode(BsonWriter writer, OffsetTime value, EncoderContext encoderContext) {
        write(writer, value)
    }

    @Override
    Class<OffsetTime> getEncoderClass() { OffsetTime }
}

