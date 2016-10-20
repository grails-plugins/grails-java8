package org.grails.plugins.bson.temporal

import org.bson.BsonReader
import org.bson.BsonType
import org.bson.BsonWriter
import spock.lang.Shared
import spock.lang.Specification
import java.time.LocalTime
import java.time.OffsetTime
import java.time.ZoneOffset

class ConvertsOffsetTimeSpec extends Specification implements ConvertsOffsetTime {

    @Shared
    OffsetTime offsetTime

    void setupSpec() {
        TimeZone.default = TimeZone.getTimeZone("America/Los_Angeles")
        LocalTime localTime = LocalTime.of(6,5,4,3)
        offsetTime = OffsetTime.of(localTime, ZoneOffset.ofHours(-6))
    }

    void "test read"() {
        given:
        BsonReader bsonReader = Mock(BsonReader) {
            1 * readString() >> '06:05:04.000000003-06:00'
        }

        when:
        OffsetTime converted = read(bsonReader)

        then:
        converted.hour == 5 //Converted to system default offset
        converted.minute == 5
        converted.second == 4
        converted.nano == 3
    }

    void "test write"() {
        given:
        BsonWriter bsonWriter = Mock(BsonWriter)

        when:
        write(bsonWriter, offsetTime)

        then:
        1 * bsonWriter.writeString('06:05:04.000000003-06:00')
    }

    void "test bson type"() {
        expect:
        bsonType() == BsonType.STRING
    }
}