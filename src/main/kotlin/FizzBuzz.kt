/**
 * print numbers till n (1...n). print fizz if number is multiple of 3 and buzz if it is multiple of 5. and fizzbuz if it is
 * multiple of both 3 and 5.
 */
fun main() {

    printFizzBuzz(20)
}

private fun printFizzBuzz(num: Int) {

    for (n in 1..num) {
        val value = when {
            n % 3 == 0 && n % 5 == 0 -> "fizzbuzz"
            n % 5 == 0 -> "buzz"
            n % 3 == 0 -> "fizz"
            else -> n.toString()
        }
        println(value)
    }
}