package io.aheggert.casidoo

fun calculateGpa(grades: List<String>): Double {
    val gradesPoint: Map<String, Double> = mapOf(
        "A" to 4.0,
        "A-" to 3.7,
        "B+" to 3.3,
        "B" to 2.7,
        "B-" to 2.3,
        "C+" to 2.0,
        "C" to 1.7,
        "C-" to 1.3,
        "D+" to 1.0,
        "D" to 0.7,
        "D-" to 0.0,
    )

    val sum: Double = grades.mapNotNull(gradesPoint::get).sum()
    return ((sum / grades.size) * 10) / 10

}