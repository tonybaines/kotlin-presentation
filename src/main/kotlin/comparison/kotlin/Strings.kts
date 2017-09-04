package comparison.kotlin

import java.time.LocalTime

val multiLine = """The Tao that is seen
Is not the true Tao, until
You bring fresh toner."""


fun LocalTime.greeting(): String = when {
    isBefore(LocalTime.NOON) -> "Morning"
    isBefore(LocalTime.of(18, 0)) -> "Afternoon"
    else -> "Evening"
}

println("Good ${LocalTime.now().greeting()} Tony.")

