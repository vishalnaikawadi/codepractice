fun romanToInteger(roman: String): Int {
    var sum = 0
    var prev = 0
    for (i in roman.lastIndex downTo 0) {
        val current = romanMap[roman[i]] ?: 0
        if (current < prev) {
            sum -= current
        } else {
            sum += current
        }
        prev = current
    }

    return sum
}

val romanMap = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun main() {

    println(romanToInteger("MCMXCIV"))
}
