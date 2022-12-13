package io.aheggert.casidoo

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@QuarkusTest
class Test2022CW41 {

    @Test
    fun truncate() {
        assertEquals("nev gon giv you up", truncate("never gonna give you up", 3));
    }
}