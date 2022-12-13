package io.aheggert.casidoo

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@QuarkusTest
class Test2022CW38 {

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("A"), 4.0),
                Arguments.of(listOf("A", "A"), 4.0),
                Arguments.of(listOf("F", "F", "F"), 0.0),
                Arguments.of(listOf("A", "A-", "B+", "B", "B-"), 3.2),
                Arguments.of(listOf("A", "B+", "C-", "A"), 3.15)
            );
        }
    }

    @ParameterizedTest(name = "{0} should get the grade {1}")
    @MethodSource("provideArguments")
    fun calculateGpa(grades: List<String>, gpa: Double) {
        assertEquals(gpa, calculateGpa(grades));
    }
}