package comparison.kotlin

val colours = listOf("Red", "Orange", "Yellow", /*..*/ "Violet")

val filtered = colours.filter { it.toLowerCase().contains("o") }
// filtered.add() -- no such method

val mutable = filtered.toMutableList()
mutable.add("Octarine")

assert(mutable.contains("Octarine"))
