import java.io.File
import java.time.Instant

val hosts = File("/etc/hosts").readText()
hosts.split('\n')
        .filter { !it.startsWith('#') }
        .map { it.split("""\s+""")[0] }
        .forEach { println(it) }

var safe: String = "foo"
safe  = null // Compilation error

val unsafe: String? = null // Compiles

if (unsafe.contains('o')) // Compilation error
if (unsafe != null) {
    if (unsafe.contains("o")) { } // OK
}

val immutable = "foo" // Type-inference
immutable = "bar" // Compilation error

// Default collections have no 'set' type methods
val things = listOf("foo", "bar", "baz")
val newThings = things.minus("boing") // 'things' unchanged

val ephemeralThings = mutableListOf("foo", "bar", "baz")
ephemeralThings.remove("baz")

data class User(val id: Long, val name: String, var lastLogin: Instant = Instant.now())

val x: Any = "bang"
x.toUpperCase() // Compilation error, no method Any#toUpperCase
// ...
if (x is String) {
    print(x.toUpperCase()) // x is automatically cast to String
}

val y = x as String // 'Unsafe' cast, may throw exception
y.toUpperCase()

val proceed = if (RED) {
    false
} else if (RED && AMBER && isClear) {
    true
} else if (GREEN) {
    true
} else {
    false
}
when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}