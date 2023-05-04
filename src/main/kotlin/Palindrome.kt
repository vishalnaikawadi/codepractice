import java.lang.StringBuilder

/**
 * Palindrome involves reversing the string (can be used any way of reversing it)
 */

fun main() {

    println(isPalindrome(101))

    println(palindromeUsingBuiltInReverse("abba"))
    println(palindromeUsingBuiltInReverse("baba"))

    println(palindromeWithNotSoIdealWay("abba"))
    println(palindromeWithNotSoIdealWay("baba"))

}


fun isPalindrome(x: Int): Boolean {
    val xStr = x.toString()
    val rStr = StringBuilder()
    for (i in xStr.lastIndex downTo 0) {
        rStr.append(xStr[i])
    }
    return xStr == rStr.toString()
}

fun palindromeUsingBuiltInReverse(str: String) =
    str == str.reversed()

fun palindromeWithNotSoIdealWay(str: String): Boolean {

    val mid = str.length / 2
    var rev = str.lastIndex
    for (i in 0..mid) {
        if (str[i] != str[rev]) {
            return false
        }
        rev--
    }

    return true
}
