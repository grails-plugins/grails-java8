package org.grails.plugins.bson.codecs

import groovy.transform.CompileStatic
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.grails.plugins.bson.temporal.ConvertsZonedDateTime
import java.time.*

/**
 * A class to translate a {@link ZonedDateTime} in MongoDB
 *
 * @author James Kleeh
 */
@CompileStatic
class ZonedDateTimeCodec implements Codec<ZonedDateTime>, ConvertsZonedDateTime {

    @Override
    ZonedDateTime decode(BsonReader reader, DecoderContext decoderContext) {
        read(reader)
    }

    @Override
    void encode(BsonWriter writer, ZonedDateTime value, EncoderContext encoderContext) {
        write(writer, value)
    }

    @Override
    Class<ZonedDateTime> getEncoderClass() { ZonedDateTime }
}