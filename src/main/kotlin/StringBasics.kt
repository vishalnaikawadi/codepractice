import java.util.Stack
import javax.swing.text.html.HTML.Tag.S


//input lahsiv si eman ym
//output my name is vishal

val str = "lahsiv si eman ym"


fun reverseString(s: String): String {

    var newString = ""//O(1)
    for (i in s.lastIndex downTo 0) { //O(n)
        newString += s[i] //O(1)
    }

    return newString
}

//input vishal is name my
//output my name is vishal
val str2 = "vishal is name my"

fun reverseWords(s: String): String {

    val sArr = s.split(" ")
    var newStr = ""
    for (i in sArr.lastIndex downTo 0) {
        newStr += sArr[i].plus(" ")
    }

    return newStr
}


//hello
//holle
//Input: s = "leetcode"
//Output: "leotcede"
val str3 = "leetcode"


fun reverseVowels(s: String): String {
    val vowels = charArrayOf('a', 'e', 'i', 'o', 'u') //the required information
    val vowelsList = mutableListOf<Char>()

    for (i in 0..s.lastIndex) { //separate out all the vowels in different list
        if (vowels.contains(s[i])) {
            vowelsList.add(s[i]) //O(n)
        }
    }

    val builder = StringBuilder() //builder is faster than += operations on String
    for (i in 0..s.lastIndex) {

        if (vowels.contains(s[i])) { //check vowels again in the same string but this time we will add it in the builder
            builder.append(
                vowelsList[vowelsList.lastIndex] //replace from item
            )
            vowelsList.removeAt(vowelsList.lastIndex) //delete that item
        } else {
            builder.append(s[i])
        }

    }

    return builder.toString()
}

//aaabc
//abaca
fun nonRepeatingCharactersInString(s: String): String {

    val hash = IntArray(26)
    for (element in s) {
        hash[element - 'a']++ //increment value at index (element - 'a') by 1
    }

    var max = 0
    var letter = 0
    for (i in hash.indices) { //find the item with max repetitions
        if (hash[i] > max) {
            max = hash[i]
            letter = i
        }
    }
    if (max > (s.length + 1) / 2) { //if max is greater than (half size + 1) of given string, then it can't give the expected result.
        return ""
    }
    val res = CharArray(s.length)
    var idx = 0
    while (hash[letter] > 0) {
        res[idx] = (letter + 'a'.code).toChar()
//        println("idx: $idx : value : ${res[idx]}")
        idx += 2
//        println(hash[letter])
        hash[letter]--
    }
    for (i in hash.indices) {
        while (hash[i] > 0) {
            if (idx >= res.size) {
                idx = 1
            }
            res[idx] = (i + 'a'.code).toChar()
            idx += 2
            hash[i]--
        }
    }
    return String(res)
}
//added a at 0_2_4
//added b at 1_3 (b added at 1 because previous value of idx >= string length otherwise it would have been added on 6..8..10)
//added c at 5

//aaabbc
//a_a_a_
//_b_b_c
//ababac

fun nonRepeatingCharactersInString1(s: String): String {
    //step 1
    val hash = IntArray(26)
    for (item in s) {
        val itemIndex = item.code - 'a'.code
        hash[itemIndex] = hash[itemIndex] + 1
    }

    //step 2
    var max = 0
    var item = 0
    for (i in hash.indices) {
        if (hash[i] > max) {
            max = hash[i]
            item = i
        }
    }

    if (max > (s.length + 1) / 2) {
        return ""
    }

    //step 3
    var idx = 0
    val results = CharArray(s.length)
    for (i in results.indices) {

        while (hash[item] > 0) {
            results[idx] = (item + 'a'.code).toChar()
            idx += 2
            hash[item]--
        }
    }

    //step 4
    for (i in results.indices) {
        while (hash[i] > 0) {
            if (idx > results.lastIndex) {
                idx = 1
            } else {
                results[idx] = (i + 'a'.code).toChar()
                idx += 2
                hash[i]--
            }
        }
    }

    return String(results)
}


fun findLongestCommonPrefix(arr: Array<String>): String {
    val common = StringBuilder()

    arr.sort()
    val first = arr[0]
    val last = arr[arr.lastIndex]
    val minLen = minOf(first.length, last.length)
    for (i in 0 until minLen) {
        if (first[i] == last[i]) {
            common.append(first[i])
        } else {
            break
        }
    }

    return common.toString()
}

//"()[]{}", "([]{})"
fun validParentheses(s: String): Boolean {

    val stack = Stack<Char>()
    for (el in s) {
        val corresponding = when (el) {
            ')' -> '('
            ']' -> '['
            '}' -> '{'
            else -> 'E'
        }
        if (stack.isNotEmpty() && stack.peek() == corresponding) {
            stack.pop()
        } else {
            stack.push(el)
        }
    }

    return stack.isEmpty()
}


fun main() {

//    println(reverseString(str))
//    println(reverseWords(str2))
//    println(reverseVowels(str3))
//    println(nonRepeatingCharactersInString("aaabc"))
//    println(nonRepeatingCharactersInString1("aaabc"))
//    println(findLongestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(validParentheses("({{{{}}}})"))
}