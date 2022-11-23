package com.example.classesandcollectionpractice

//Task 2 create enumeration for dayPart property
enum class DayPart {
    MORNING, AFTERNOON, NIGHT
}

//Task 1 create a data class
data class Event(
    val title: String,
    val description: String? = null,
    val dayPart: DayPart,
    val duration: Int
)
    //Task 7
    val Event.durationOfEvent: String // when extending property need to be declared after the class not outside
    get() = if(this.duration < 60){
        "short"
    } else {
        "long"
    }

fun main(){
    val eventOne = Event("Study Kotlin",
        "Commit to studying kotlin at least 15 minutes per day",
        dayPart = DayPart.NIGHT,
        duration = 15
    )
    //Task 3 refactored to mutableListOf
    val eventList = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", dayPart = DayPart.MORNING, duration = 0),
        Event(title = "Eat breakfast", dayPart = DayPart.MORNING, duration = 15),
        Event(title = "Learn about Kotlin", dayPart = DayPart.AFTERNOON, duration = 30),
        Event(title = "Practice Compose", dayPart = DayPart.AFTERNOON, duration = 60),
        Event(title = "Watch latest DevBytes video", dayPart = DayPart.AFTERNOON, duration = 10),
        Event(title = "Check out latest Android Jetpack library", dayPart = DayPart.NIGHT, duration = 45)
    )

    //Task 4 find how many events has lower than 60 minutes duration
    val eventDurationGroup = eventList.filter{it.duration < 60}
    val shortDurationEventTotal = eventDurationGroup.size
    println(eventDurationGroup)
    println( "Number of short events is: $shortDurationEventTotal")

    //Task 5 make a summary of all events base on DayPart
    val morningEvent = eventList.filter{ it.dayPart == DayPart.MORNING }
    val afternoonEvent = eventList.filter{ it.dayPart == DayPart.AFTERNOON}
    val nightEvent = eventList.filter { it.dayPart == DayPart.NIGHT }

    println("Number of morning events: ${morningEvent.size}")
    println("Number of afternoon events: ${afternoonEvent.size}")
    println("Number of evening events: ${nightEvent.size}")

    //Task 6 reduce the code from println("Last event of the day: ${events[events.size - 1].title}") toi get the last event
    println("Last event of the day: ${eventList.last().title}")//answer

    //Task 7

    println("Duration of first event of the day: ${eventList[0].durationOfEvent}")

//Task 5 solution from codelab
//    val groupedEvents = eventList.groupBy { it.dayPart }
//    groupedEvents.forEach { (dayPart, events) ->
//        println("$dayPart: ${events.size} events")
//    }

}

//Task 3, refactor this code to a single variable
//val event1 = Event(title = "Wake up", description = "Time to get up", daypart = DayPart.MORNING, duration = 0)
//val event2 = Event(title = "Eat breakfast", daypart = DayPart.MORNING, duration = 15)
//val event3 = Event(title = "Learn about Kotlin", daypart = DayPart.AFTERNOON, duration = 30)
//val event4 = Event(title = "Practice Compose", daypart = DayPart.AFTERNOON, duration = 60)
//val event5 = Event(title = "Watch latest DevBytes video", daypart = DayPart.AFTERNOON, duration = 10)
//val event6 = Event(title = "Check out latest Android Jetpack library", daypart = DayPart.NIGHT, duration = 45)