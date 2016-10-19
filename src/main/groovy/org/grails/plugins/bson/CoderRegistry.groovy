package org.grails.plugins.bson

import groovy.transform.CompileStatic
import org.grails.datastore.bson.codecs.decoders.SimpleDecoder
import org.grails.datastore.bson.codecs.encoders.SimpleEncoder
import org.grails.plugins.bson.decoders.*
import org.grails.plugins.bson.encoders.*
import java.time.*

@CompileStatic
class CoderRegistry {

    static void registerEncoders() {
        Map<Class, SimpleEncoder.TypeEncoder> encoders = SimpleEncoder.SIMPLE_TYPE_ENCODERS

        encoders[LocalDate] = new LocalDateEncoder()
        encoders[LocalDateTime] = new LocalDateTimeEncoder()
        encoders[LocalTime] = new LocalTimeEncoder()
        encoders[OffsetDateTime] = new OffsetDateTimeEncoder()
        encoders[OffsetTime] = new OffsetTimeEncoder()
        encoders[ZonedDateTime] = new ZonedDateTimeEncoder()
    }

    static void registerDecoders() {
        Map<Class, SimpleDecoder.TypeDecoder> decoders = SimpleDecoder.SIMPLE_TYPE_DECODERS

        decoders[LocalDate] = new LocalDateDecoder()
        decoders[LocalDateTime] = new LocalDateTimeDecoder()
        decoders[LocalTime] = new LocalTimeDecoder()
        decoders[OffsetDateTime] = new OffsetDateTimeDecoder()
        decoders[OffsetTime] = new OffsetTimeDecoder()
        decoders[ZonedDateTime] = new ZonedDateTimeDecoder()
    }
}
