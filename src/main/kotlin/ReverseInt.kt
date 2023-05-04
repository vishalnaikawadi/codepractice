fun main() {

    println(reverseIntUsingString(500))
    println(reverseIntUsingStringAndHandleNegative(-29))

}

//this solution does not work well with negative numbers
fun reverseIntUsingString(num: Int): Int {
    return num.toString().reversed().toInt()
}

fun reverseIntUsingStringAndHandleNegative(num: Int): Int {

    return if (num < 0) { //check if number is negative
        //if yes, first make it positive because reversed() function will put the negative sign at the end,
        // which will result in NumberFormatException while doing .toInt()
        (num * -1).toString().reversed().toInt() * -1
    } else {
        num.toString().reversed().toInt()
    }
}
