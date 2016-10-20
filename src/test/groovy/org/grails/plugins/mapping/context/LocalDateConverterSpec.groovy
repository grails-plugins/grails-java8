package org.grails.plugins.mapping.context

import org.grails.plugins.converters.LocalDateConverter
import spock.lang.Shared
import spock.lang.Specification
import java.time.LocalDate

class LocalDateConverterSpec extends Specification implements LocalDateConverter {

    @Shared
    LocalDate localDate

    void setupSpec() {
        localDate = LocalDate.of(1941, 1, 5)
    }

    void "test convert to long"() {
        expect:
        convert(localDate) == -914803200000L
    }

    void "test convert from long"() {
        expect:
        convert(-914803200000L) == localDate
    }

}
