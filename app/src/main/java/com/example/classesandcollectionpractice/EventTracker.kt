package com.example.classesandcollectionpractice

enum class DayPart {
    MORNING, AFTERNOON, NIGHT
}

data class Event(
    val title: String,
    val description: String? = null,
    val dayPart: String,
    val duration: Int
)

fun main(){
    val eventOne = Event("Study Kotlin",
        "Commit to studying kotlin at least 15 minutes per day",
        dayPart = DayPart.NIGHT.toString(),
        duration = 15
    )

    println(eventOne)
}