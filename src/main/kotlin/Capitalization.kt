fun main() {

    println(capitalizeSentenceWithList("vishal naikawadi !wow"))
    println(capitalizeSentenceWithArraySlice("vishal naikawadi !wow"))
    println(capitalizeSentenceManual("vishal naikawadi !wow"))
}

private fun capitalizeSentenceWithList(str: String): String {

    if (str.isEmpty()) return str

    val arr = str.split(" ").toMutableList()

    for (i in arr.indices) {
        arr[i] = arr[i].replaceFirst(arr[i][0].toString(), arr[i][0].uppercase(), true)
    }

    return arr.joinToString(" ")
}

private fun capitalizeSentenceWithArraySlice(str: String): String {

    if (str.isEmpty()) return str

    val arr = str.split(" ").toMutableList()

    for (i in arr.indices) {
        val first = arr[i][0].uppercase()
        arr[i] = first + arr[i].slice(1..arr[i].lastIndex)
    }

    return arr.joinToString(" ")
}


private fun capitalizeSentenceManual(str: String): String {

    if (str.isEmpty()) return str

    var result = str[0].uppercase() //because there's nothing on left of first character. so by default make it capital.

    for (i in 1..str.lastIndex) { //start loop from 2nd index
        result += if (str[i - 1] == ' ') { //check if previous index has a space
            str[i].uppercase()
        } else {
            str[i]
        }
    }

    return result
}