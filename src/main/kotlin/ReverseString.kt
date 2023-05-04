/**
 * All possible solutions for reversing the string
 */
fun main() {

    println(reverseUsingDefaultFunction("hello"))
    println(reverseTheStringUsingArray("hello"))
    println(reverseTheStringUsingForLoop("hello"))
    println(reverseTheStringUsingReduceFunction("hello"))
}

private fun reverseUsingDefaultFunction(str: String) = str.reversed()

private fun reverseTheStringUsingArray(str: String): String {
    return str
        .split("")
        .reversed()
        .joinToString("")
}

private fun reverseTheStringUsingForLoop(str: String): String {
    var reversed = ""

    for (s in str) { //we don't even have to loop from last to start.
        reversed = s + reversed //this line is important
    }

    return reversed
}

private fun reverseTheStringUsingReduceFunction(str: String): String {
    return str.split("").reduce { acc, s ->
        s + acc
    }
}