import kotlin.math.roundToInt

fun main() {

//    stepShapeWithNLevel(5)
//    stepShapeWithNLeveRecursively(15)
    pyramidIterative(4)
    pyramidRecursive(4)
}

/**
 *Write a function that accepts a positive number N.
 * The function should console log a step shape with N levels using the # character.
 * Make sure the step has spaces on the right hand side!
 */
//*^^
//**^
//***
private fun stepShapeWithNLevel(level: Int) {

    for (i in 0 until level) {
        for (j in 0 until level) {
            if (j <= i) {
                print("*")
            } else {
                print("")
            }
        }
        println()
    }
}

private fun stepShapeWithNLeveRecursively(level: Int) {

    makeRecursiveCall(level)
}

private fun makeRecursiveCall(level: Int, row: Int = 0, str: String = "") {

    if (level == row) return

    if (level == str.length) {
        println(str)
        return makeRecursiveCall(level, row + 1, "")
    }

    val strNew = if (str.length <= row) {
        "$str*"
    } else {
        "$str "
    }


    return makeRecursiveCall(level, row, strNew)

}

/**
 * Write a function that accepts a positive number N.
 * The function should console log a pyramid shape with N levels using the # character.
 * Make sure the pyramid has spaces on both the left *and* right hand sides.
 */
//^^*^^
//^***^
//*****
private fun pyramidIterative(level: Int) {

    val col = (level * 2) - 1

    val mid = col / 2
    for (i in 0 until level) {
        for (j in 0 until col) {

            if (j >= mid - i && j <= mid + i) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}

private fun pyramidRecursive(level: Int, row: Int = 0, str: String = "") {

    if (level == row) return

    val col = (level * 2) - 1
    val mid = col / 2

    if (str.length == col) {

        println(str)
        return pyramidRecursive(level, row + 1, "")
    }

    val strNew = if (str.length >= mid - row && str.length <= mid + row) {
        "$str*"
    } else {
        "$str "
    }

    return pyramidRecursive(level, row, strNew)
}