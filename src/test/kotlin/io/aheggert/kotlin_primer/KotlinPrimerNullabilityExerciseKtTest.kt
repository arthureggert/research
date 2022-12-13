package io.aheggert.kotlin_primer


import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@QuarkusTest
class KotlinPrimerNullabilityExerciseKtTest {

    val personWithAge = Person(
        firstName = "Honza",
        nickname = "Párek",
        lastName = "Párker",
        age = 32,
        PhoneNumber(null, "123456789")
    )

    val personWithoutAge = Person(
        firstName = "Franta",
        lastName = "Zvadlý",
        age = null,
        phone = null
    )

    val withPhonePrefix = PhoneNumber("+314", "123321")

    val withoutPhonePrefix = PhoneNumber(null, "123321")

    @Test
    fun testCanBangBang() {
        Assertions.assertTrue(canBangBangKotlin(personWithAge, 32))
        Assertions.assertTrue(canBangBangJava(personWithAge, 32))

        Assertions.assertFalse(canBangBangKotlin(personWithAge, 33))
        Assertions.assertFalse(canBangBangJava(personWithAge, 33))

        Assertions.assertFalse(canBangBangKotlin(personWithoutAge, 33))
        Assertions.assertFalse(canBangBangJava(personWithoutAge, 33))
    }

    @Test
    fun testFormatPhone() {
        Assertions.assertEquals("+314 123321", formatPhoneJava(withPhonePrefix))
        Assertions.assertEquals("+314 123321", formatPhoneKotlin(withPhonePrefix))

        Assertions.assertEquals("+420 123321", formatPhoneJava(withoutPhonePrefix))
        Assertions.assertEquals("+420 123321", formatPhoneKotlin(withoutPhonePrefix))
    }

    @Test
    fun testHumanStr() {
        Assertions.assertEquals(
            """
            |Name: Honza 'Párek' Párker
            |Age: 32
            |Phone: +420 123456789
            """.trimMargin(),
            humanStrJava(personWithAge)
        )
        Assertions.assertEquals(
            """
            |Name: Honza 'Párek' Párker
            |Age: 32
            |Phone: +420 123456789
            """.trimMargin(),
            humanStrKotlin(personWithAge)
        )

        Assertions.assertEquals(
            """
            |Name: Franta  Zvadlý
			|Age: Unknown
			|Phone: Unknown
            """.trimMargin(),
            humanStrKotlin(personWithoutAge)
        )
    }
}