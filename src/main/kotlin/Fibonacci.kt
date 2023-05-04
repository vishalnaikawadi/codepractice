import java.util.*

/**
 * Print out the n-th entry in the fibonacci series.
 * The fibonacci series is an ordering of numbers where each number is the sum of the preceding two.
 */
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
fun main() {

//    println(fibonacciIterative(5))
//    println(fibonacciIterativeWithList(5))
//    println(fibonacciRecursive(30))
//    println(fibonacciRecursiveMemoization(30))


    val lList = LinkedList<String>()
    lList.offer("A")
    lList.addFirst("D")
    lList.add("B")
    lList.addFirst("C")
    lList.removeFirst()
    lList.removeLast()
    lList.addLast("E")
    lList.pop()
    lList.poll()

    println(lList.toString())
    println(lList.peek())

}

private fun fibonacciIterative(n: Int): Int {

    if (n == 0) return 0
    if (n == 1) return 1

    var first = 0
    var second = 1
    var sum = 0

    for (i in 2..n) {

        sum = first + second
        first = second
        second = sum

    }

    return sum
}

private fun fibonacciIterativeWithList(n: Int): Int {

    val result = mutableListOf(0, 1)

    for (i in 2..n) {
        val a = result[i - 1]
        val b = result[i - 2]
        result.add(a + b)
    }

    return result[n]
}

private fun fibonacciRecursive(n: Int): Int {

    if (n < 2) return n

    return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1)
}

private fun fibonacciRecursiveMemoization(n: Int, memo: MutableMap<Int, Int> = mutableMapOf()): Int {

    if (n < 2) return n

    return memo.getOrPut(n) {
        fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1)
    }
}
