package comparison.kotlin

import comparison.kotlin.Lights.*

enum class Lights {
    RED, AMBER, GREEN
}

val lights: Lights = RED

val proceed =
        if (lights == RED) false
        else if (lights == RED && lights == AMBER) true
        else lights == GREEN
