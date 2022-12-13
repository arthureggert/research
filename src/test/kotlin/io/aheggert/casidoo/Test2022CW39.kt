package io.aheggert.casidoo

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@QuarkusTest
class Test2022CW39 {

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, "1st"),
                Arguments.of(2, "2nd"),
                Arguments.of(3, "3rd"),
                Arguments.of(4, "4th"),
                Arguments.of(57, "57th")
            );
        }
    }

    @ParameterizedTest(name = "{0} ordinal is {1}")
    @MethodSource("provideArguments")
    fun ordinal(number: Int, ordinal: String) {
        assertEquals(ordinal, oridinal(number));
    }
}