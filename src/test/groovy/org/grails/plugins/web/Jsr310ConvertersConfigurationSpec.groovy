package org.grails.plugins.web

import org.grails.plugins.databinding.DataBindingGrailsPlugin
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

class Jsr310ConvertersConfigurationSpec extends Specification {

    @Shared
    List<String> formats = ["yyyy-MM-dd'T'HH:mm:ssZ", "HH:mm:ssZ", "HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd"]

    @Shared
    Jsr310ConvertersConfiguration config = new Jsr310ConvertersConfiguration(formatStrings: formats)

    @Shared
    LocalDate localDate = LocalDate.of(1941, 1, 5)

    @Shared
    LocalTime localTime = LocalTime.of(8, 0, 0, 0)




    @Shared
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

    void setupSpec() {
        calendar.set(1941, 0, 5, 8, 0, 0)
    }

    void "localDateTimeConverter"() {
        given:
        def converter = config.localDateTimeConverter()

        expect:
        converter.targetType == LocalDateTime
        converter.convert("1941-01-05T08:00:00", "yyyy-MM-dd'T'HH:mm:ss") instanceof LocalDateTime
    }

    void "localDateTimeValueConverter"() {
        def converter = config.localDateTimeValueConverter()

        expect:
        converter.targetType == LocalDateTime
        converter.canConvert('')
        converter.convert("1941-01-05T08:00:00") instanceof LocalDateTime
    }

    void "localDateTimeStructuredBindingEditor"() {
        given:
        def converter = config.localDateTimeStructuredBindingEditor()
        LocalDateTime date = converter.getDate(calendar)

        expect:
        converter.targetType == LocalDateTime
        date.year == 1941
        date.month == Month.JANUARY
        date.dayOfMonth == 5
        date.hour == 8
        date.minute == 0
        date.second == 0
    }

    void "localDateConverter"() {
        given:
        def converter = config.localDateConverter()

        expect:
        converter.targetType == LocalDate
        converter.convert("1941-01-05", "yyyy-MM-dd") instanceof LocalDate
    }

    void "localDateValueConverter"() {
        def converter = config.localDateValueConverter()

        expect:
        converter.targetType == LocalDate
        converter.canConvert('')
        converter.convert("1941-01-05") instanceof LocalDate
    }

    void "localDateStructuredBindingEditor"() {
        given:
        def converter = config.localDateStructuredBindingEditor()
        LocalDate date = converter.getDate(calendar)

        expect:
        converter.targetType == LocalDate
        date.year == 1941
        date.month == Month.JANUARY
        date.dayOfMonth == 5
    }

    void "localTimeConverter"() {
        given:
        def converter = config.localTimeConverter()

        expect:
        converter.targetType == LocalTime
        converter.convert("08:00:00", "HH:mm:ss") instanceof LocalTime
    }

    void "localTimeValueConverter"() {
        def converter = config.localTimeValueConverter()

        expect:
        converter.targetType == LocalTime
        converter.canConvert('')
        converter.convert("08:00:00") instanceof LocalTime
    }

    void "localTimeStructuredBindingEditor"() {
        given:
        def converter = config.localTimeStructuredBindingEditor()
        LocalTime date = converter.getDate(calendar)

        expect:
        converter.targetType == LocalTime
        date.hour == 8
        date.minute == 0
        date.second == 0
    }

    void "offsetTimeConverter"() {
        given:
        def converter = config.offsetTimeConverter()

        expect:
        converter.targetType == OffsetTime
        converter.convert("08:00:00+0000", "HH:mm:ssZ") instanceof OffsetTime
    }

    void "offsetTimeValueConverter"() {
        def converter = config.offsetTimeValueConverter()

        expect:
        converter.targetType == OffsetTime
        converter.canConvert('')
        converter.convert("08:00:00+0000") instanceof OffsetTime
    }

    void "offsetTimeStructuredBindingEditor"() {
        given:
        def converter = config.offsetTimeStructuredBindingEditor()
        OffsetTime date = converter.getDate(calendar)

        expect:
        converter.targetType == OffsetTime
        date.hour == 8
        date.minute == 0
        date.second == 0
    }

    void "offsetDateTimeConverter"() {
        given:
        def converter = config.offsetDateTimeConverter()

        expect:
        converter.targetType == OffsetDateTime
        converter.convert("1941-01-05T08:00:00+0000", "yyyy-MM-dd'T'HH:mm:ssZ") instanceof OffsetDateTime
    }

    void "offsetDateTimeValueConverter"() {
        def converter = config.offsetDateTimeValueConverter()

        expect:
        converter.targetType == OffsetDateTime
        converter.canConvert('')
        converter.convert("1941-01-05T08:00:00+0000") instanceof OffsetDateTime
    }

    void "offsetDateTimeStructuredBindingEditor"() {
        given:
        def converter = config.offsetDateTimeStructuredBindingEditor()
        OffsetDateTime date = converter.getDate(calendar)

        expect:
        converter.targetType == OffsetDateTime
        date.year == 1941
        date.month == Month.JANUARY
        date.dayOfMonth == 5
        date.hour == 8
        date.minute == 0
        date.second == 0
    }

    void "zonedDateTimeConverter"() {
        given:
        def converter = config.zonedDateTimeConverter()

        expect:
        converter.targetType == ZonedDateTime
        converter.convert("1941-01-05T08:00:00+0000", "yyyy-MM-dd'T'HH:mm:ssZ") instanceof ZonedDateTime
    }

    void "zonedDateTimeValueConverter"() {
        def converter = config.zonedDateTimeValueConverter()

        expect:
        converter.targetType == ZonedDateTime
        converter.canConvert('')
        converter.convert("1941-01-05T08:00:00+0000") instanceof ZonedDateTime
    }

    void "zonedDateTimeStructuredBindingEditor"() {
        given:
        def converter = config.zonedDateTimeStructuredBindingEditor()
        ZonedDateTime date = converter.getDate(calendar)

        expect:
        converter.targetType == ZonedDateTime
        date.year == 1941
        date.month == Month.JANUARY
        date.dayOfMonth == 5
        date.hour == 8
        date.minute == 0
        date.second == 0
    }

    void "periodConverter"() {
        given:
        def converter = config.periodConverter()

        expect:
        converter.targetType == Period
        converter.convert("P2D", null) instanceof Period
    }

    void "periodValueConverter"() {
        def converter = config.periodValueConverter()

        expect:
        converter.targetType == Period
        converter.canConvert('')
        converter.convert("P2D") instanceof Period
    }
}
