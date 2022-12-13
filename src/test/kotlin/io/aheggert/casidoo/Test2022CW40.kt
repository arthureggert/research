package io.aheggert.casidoo

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@QuarkusTest
class Test2022CW40 {

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3, 7, 5, listOf(3, 7, 10, 17, 27)),
                Arguments.of(0, 1, 10, listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)),
                Arguments.of(10, 20, 5, listOf(10, 20, 30, 50, 80)),
                Arguments.of(0, 0, 5, listOf(0, 0, 0, 0, 0)),
                Arguments.of(1, 1, 5, listOf(1, 1, 2, 3, 5))
            );
        }
    }

    @ParameterizedTest(name = "{0}, {1} with {2} fibonnaci numbers is {3}")
    @MethodSource("provideArguments")
    fun fibonnaci(first: Int, second: Int, total: Int, expected: List<Int>) {
        assertEquals(expected, fibonnaci(first, second, total))
    }
}