package io.aheggert.kotlin_primer

class PhoneNumber(val prefix: String?, val number: String)

class Person(
    val firstName: String, val nickname: String? = null, val lastName: String,
    val age: Int?,
    val phone: PhoneNumber?
) {
    init {
        require((age ?: Int.MAX_VALUE) > 0) { "Age cannot be negative" }
    }
}

val Person.quotedNick get(): String? = nickname?.let { "'$it'" }
val Person.phoneString get(): String? = phone?.let(::formatPhoneKotlin)

fun canBangBangJava(person: Person?, consentAge: Int): Boolean {
    if (person == null) {
        throw IllegalArgumentException("Person cannot be null");
    }

    if (person.age == null) {
        return false
    }

    return person.age >= consentAge
}

fun canBangBangKotlin(person: Person, consentAge: Int): Boolean {
    return (person.age ?: Int.MIN_VALUE) >= consentAge
}

fun formatPhoneJava(phone: PhoneNumber?, defaultPrefix: String = "+420"): String {
    if (phone == null) {
        throw IllegalArgumentException("Phone cannot be null");
    }
    if (phone.number == null) {
        throw IllegalArgumentException("Phone.number cannot be null");
    }
    if (defaultPrefix == null) {
        throw IllegalArgumentException("defaultPrefix cannot be null");
    }

    if (phone.prefix != null) {
        return phone.prefix + " " + phone.number
    }

    return defaultPrefix + " " + phone.number
}

fun formatPhoneKotlin(phone: PhoneNumber, defaultPrefix: String = "+420"): String {
    return "${(phone.prefix ?: defaultPrefix)} ${phone.number}"
}

fun humanStrJava(person: Person): String {
    if (person == null) {
        throw IllegalArgumentException("Person cannot be null");
    }

    val builder = StringBuilder()

    if (person.firstName == null) {
        throw IllegalArgumentException("Person.firstName cannot be null");
    }

    if (person.lastName == null) {
        throw IllegalArgumentException("Person.lastName cannot be null");
    }

    val quotedNick = if (person.quotedNick == null) "" else person.quotedNick!!
    builder.append("Name: ")
        .append(person.firstName).append(" ").append(quotedNick).append(" ").append(person.lastName)
        .append("\n")

    builder.append("Age: ")
        .append(if (person.age == null) "Unknown" else person.age.toString())
        .append("\n")

    builder.append("Phone: ")
        .append(if (person.phoneString == null) "Unknown" else person.phoneString)

    return builder.toString()
}

fun humanStrKotlin(person: Person): String {
    return """
    |Name: ${person.firstName} ${person.quotedNick ?: ""} ${person.lastName}
    |Age: ${person.age ?: "Unknown"}
    |Phone: ${person.phoneString ?: "Unknown"}
    """.trimMargin()
}