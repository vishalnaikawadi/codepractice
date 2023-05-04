fun main() {

    println(findTheRepeatedCharUsingHashmap("h f b s e a"))//space will print
//    println(findTheRepeatedCharUsingArray("hhhHHHaaaa"))
}

//hello there!

private fun findTheRepeatedCharUsingHashmap(str: String): Char {

    val hashMap = hashMapOf<Char, Int>()
    for (i in str.indices) {
        hashMap[str[i]] = (hashMap[str[i]] ?: 0) + 1 //use .toLowerCase() if we're supposed to treat them equally.
    }

    val mostRepeated = /*hashMap.maxWith { o1, o2 -> o1.value.compareTo(o2.value) }*/hashMap.maxBy { it.value }

    return mostRepeated.key
}


//not ideal for numbers in the string
private fun findTheRepeatedCharUsingArray(str: String): Char? {

    val asciiOfA = 'a'.code
    val arr = IntArray(26)
    for (element in str.lowercase()) {
        arr[(element.code - asciiOfA)]++
    }

    var max = 0
    var mostRepeated: Char? = null
    arr.forEachIndexed { index, value ->
        if (value > max) {
            max = value
            mostRepeated = (asciiOfA + index).toChar()
        }
    }

    return mostRepeated
}