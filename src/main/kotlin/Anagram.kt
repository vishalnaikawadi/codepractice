/**
 * Check to see if two provided strings are anagrams of each other.
 * One string is an anagram of another if it uses the same characters in the same quantity.
 *
 * Only consider characters, not spaces or punctuation
 * Consider capital letters to be the same as lower case
 */
fun main() {

    println(
        anagrams("rai safety", "fairy tales")
    )

    println(
        anagramWithSort("rail safety", "fairy tales")
    )

}

private fun anagrams(stringA: String, stringB: String): Boolean {
    val reg = Regex("[^A-Za-z]")
    val onlyAtoZstr1 = stringA.replace(reg, "").lowercase()
    val onlyAtoZstr2 = stringB.replace(reg, "").lowercase()


    val arrA = IntArray(26)
    val arrB = IntArray(26)

    val asciiA = 'a'.code
    for (s in onlyAtoZstr1) {
        arrA[(s.code - asciiA)]++
    }

    for (s in onlyAtoZstr2) {
        arrB[(s.code - asciiA)]++
    }


    return arrA.contentEquals(arrB)
}

private fun anagramWithSort(stringA: String, stringB: String): Boolean {
    val reg = Regex("[^A-Za-z]")
    val onlyAtoZstr1 = stringA.replace(reg, "").lowercase()
    val onlyAtoZstr2 = stringB.replace(reg, "").lowercase()

    return onlyAtoZstr1.split("").sorted() == onlyAtoZstr2.split("").sorted()
}