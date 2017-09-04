package comparison.kotlin

fun findAuthorByTitle(title: String): Author {
    //...
    return Author(name = "J.K. Rowling", pseudonym = "Robert Galbraith")
}


// What happens if the title isn't found?
val author = findAuthorByTitle("...")
println(author.name)
