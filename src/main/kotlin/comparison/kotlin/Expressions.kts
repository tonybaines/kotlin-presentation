package comparison.kotlin

import comparison.kotlin.Expressions.Lights.*
import java.util.Random

enum class Lights {
    RED, AMBER, GREEN
}

val lights: Lights = RED

val proceed =
        if (lights == RED) false
        else if (lights == RED && lights == AMBER) true
        else lights == GREEN

val size = when (Random().nextInt(100)) {
    in 0.. 10 -> "low"
    in 11..50 -> "medium"
    else -> "high"
}