fun main() {

    println(reverseTheString("vishal"))
}

fun reverseTheString(str: String): String {

    val strNew = StringBuilder()

    for (i in str.lastIndex downTo 0) { //O(n)
        strNew.append(str[i])
    }

    return strNew.toString()
}