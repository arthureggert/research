package io.aheggert.casidoo

fun fibonnaci(first: Int, second: Int, total: Int): List<Int> {
    return if (total == 0) {
        listOf()
    } else {
        listOf(first) + fibonnaci(second, first + second, total - 1)
    }
}