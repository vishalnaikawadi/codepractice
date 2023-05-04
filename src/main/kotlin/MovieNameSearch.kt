fun main() {


    val names = listOf(
        "Aquaman",
        "Spider-Man: Into the Spider-Verse",
        "KGF",
        "Ralph Breaks The Internet",
        "The Grinch",
        "the good doctor",
        "Bohemian Rhapsody",
        "Maari",
        "Dilwale Dulhania Le Jaayenge"
    )
    val input = "g"

    val result = searchName2(input, names)
    if (result.isNotEmpty()) {
        println("Found ${result.size} matches: ${result.joinToString()}")
    } else {
        println("No match found")
    }

    val numbersMap=mutableMapOf("one" to 1,"two" to 2, "three" to 3,"threeAgain" to 3)

    numbersMap.values.remove(3)

    println(numbersMap.toString())

}

fun searchName(input: String, names: List<String>): List<String> {
    val result = mutableListOf<String>()
    for (name in names) {
        val nameParts = name.split(" ")
        if (nameParts.isNotEmpty()) {
            val firstName = nameParts[0]
            val lastName = nameParts.last()
            if (firstName.startsWith(input, ignoreCase = true) || lastName.startsWith(input, ignoreCase = true)) {
                result.add(name)
            }
        }
    }
    return result
}

fun searchName2(input: String, movies: List<String>): List<String> {

    return movies
        .filter { movie ->
            movie
                .split(" ")
                .any { word ->
                    word
                        .startsWith(input, ignoreCase = true)
                }
        }
        .take(5)
}

enum class CCCC{

}