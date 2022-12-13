package io.aheggert.casidoo

import io.aheggert.casidoo.cornerHit
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

@QuarkusTest
class Test2022CW37 {

    @Test
    fun cornerHit() {
        val dimensions = Pair(5, 5)
        val initialCoordinates = Pair(0, 0)
        val screenSize = Pair(100, 100)
        assertTrue(cornerHit(dimensions, initialCoordinates, screenSize));
        assertFalse(cornerHit(dimensions, Pair(45, 70), Pair(400, 200)))
    }
}