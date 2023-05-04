fun main() {

    println(vowelsIterative("Aaassiiooooou?"))
}

//vowels('Why do you ask?'); --> 4
private fun vowelsIterative(str: String): Int {

    val vowels = "aeiou"

    var count = 0
    for (s in str) {
        if (vowels.contains(s.lowercase())) {
            count++
        }
    }

    return count
}

private fun vowelsRecursive(str: String): Int {
    return 0
}