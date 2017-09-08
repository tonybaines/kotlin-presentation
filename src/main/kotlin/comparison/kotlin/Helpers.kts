// Locally-scoped additions to any 'String' instance
fun String.isPalindrome(): Boolean =
        this.equals(this.reverse(), ignoreCase = true)

fun String.reverse(): String {
    var b = StringBuffer()
    for (i in this.length - 1 downTo 0) {
        b.append(this[i])
    }
    return b.toString()
}

val words = listOf("Anna", "Eye", "Noon", "Civic", "Level")

assert(words.all { it.isPalindrome() })
