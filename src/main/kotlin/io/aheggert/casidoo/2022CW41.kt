package io.aheggert.casidoo

fun truncate(string: String, length: Int): String {
    return string.split(" ").joinToString(" ") {
        if (it.length > length) {
            it.substring(0, length)
        } else {
            it
        }
    }
}