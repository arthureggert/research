package io.aheggert.casidoo

fun oridinal(n: Int): String {
    val suffix = when (n % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
    return "$n$suffix"
}