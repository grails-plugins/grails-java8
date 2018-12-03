package org.grails.plugins.web

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.FormatStyle
import java.time.temporal.TemporalAccessor

class Jsr310TagDateHelper implements GrailsTagDateHelper {

    @Override
    Object getTimeZone(Object timeZone) {
        if (timeZone != null) {
            if (timeZone instanceof ZoneId) {
                timeZone
            } else if (timeZone instanceof TimeZone) {
                timeZone.toZoneId()
            } else {
                ZoneId.of(timeZone.toString())
            }
        } else {
            ZoneId.systemDefault()
        }
    }

    @Override
    Object getFormatFromPattern(String format, Object timeZone, Locale locale) {
        DateTimeFormatter.ofPattern(format, locale).withZone((ZoneId)timeZone)

    }

    @Override
    Object getDateFormat(String dateStyle, Object timeZone, Locale locale) {
        new DateTimeFormatterBuilder()
                .appendLocalized(parseStyle(dateStyle), null)
                .toFormatter(locale)
                .withZone((ZoneId)timeZone)
    }

    @Override
    Object getTimeFormat(String timeStyle, Object timeZone, Locale locale) {
        new DateTimeFormatterBuilder()
                .appendLocalized(null, parseStyle(timeStyle))
                .toFormatter(locale)
                .withZone((ZoneId)timeZone)
    }

    @Override
    Object getDateTimeFormat(String dateStyle, String timeStyle, Object timeZone, Locale locale) {
        new DateTimeFormatterBuilder()
                .appendLocalized(parseStyle(dateStyle), parseStyle(timeStyle))
                .toFormatter(locale)
                .withZone((ZoneId)timeZone)
    }

    @Override
    String format(Object formatter, Object date) {
        TemporalAccessor instant
        if (date instanceof Date) {
            instant = date.toInstant()
        } else if (date instanceof Calendar) {
            instant = date.toInstant()
        } else if (date instanceof Long) {
            instant = Instant.ofEpochMilli(date)
        } else if (date instanceof TemporalAccessor) {
            instant = date
        } else {
            throw new IllegalArgumentException("Cannot format class as date: " +
                    (date == null ? "<null>" : date.getClass().getName()));
        }
        ((DateTimeFormatter)formatter).format(instant)
    }

    private static FormatStyle parseStyle(String styleStr) {
        switch (styleStr) {
            case 'FULL':   return FormatStyle.FULL
            case 'LONG':   return FormatStyle.LONG
            case 'MEDIUM': return FormatStyle.MEDIUM
            default:       return FormatStyle.SHORT
        }
    }

    @Override
    Boolean supportsDatePicker(Class clazz) {
        clazz == Date || TemporalAccessor.isAssignableFrom(clazz)
    }

    /**
     *
     * @param date The date object
     * @return null if date Object is not an instance of {@link java.util.Date}, {@link LocalDateTime}, {@link LocalDate}, {@link OffsetDateTime}, {@link ZonedDateTime} or {@link TemporalAccessor}
     */
    @Override
    GregorianCalendar buildCalendar(Object date) {
        if (date instanceof Date) {
            GregorianCalendar c = new GregorianCalendar()
            c.setTime((Date)date)
            c
        } else {
            ZonedDateTime zonedDateTime
            if (date instanceof LocalDateTime) {
                zonedDateTime = ZonedDateTime.of(date, ZoneId.systemDefault())
            } else if (date instanceof LocalDate) {
                zonedDateTime = ZonedDateTime.of(date, LocalTime.MIN, ZoneId.systemDefault())
            } else if (date instanceof OffsetDateTime) {
                zonedDateTime = ((OffsetDateTime) date).toZonedDateTime()

            } else if (date instanceof ZonedDateTime) {
                zonedDateTime = (ZonedDateTime) date

            } else if (date instanceof TemporalAccessor) {
                zonedDateTime = ZonedDateTime.from(date)
            }
            if (zonedDateTime == null) {
                return null
            }
            GregorianCalendar.from(zonedDateTime)
        }
    }

}
