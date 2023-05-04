/**
 * Write a function that accepts an integer N and returns a NxN spiral matrix.
 *
 */
fun main() {

    matrixWithPattern(10).forEach {
        println(it.toString())
    }


}

//matrix(4);
//          sCol        eCol
//sRow     [[1,   2,  3, 4],
//          [12, 13, 14, 5],
//          [11, 16, 15, 6],
//eRow      [10,  9,  8, 7]]

private fun matrix(num: Int): MutableList<MutableList<Int>> {

    val matrix = MutableList(num) { MutableList(num) { 0 } }

    var sRow = 0
    var eRow = num - 1
    var sCol = 0
    var eCol = num - 1
    var count = 1

    while (sCol <= eCol && sRow <= eRow) {

        //loop 1
        for (i in sCol..eCol) {
            matrix[sRow][i] = count
            count++
        }
        sRow++

        //loop 2
        for (i in sRow..eRow) {
            matrix[i][eCol] = count
            count++
        }
        eCol--

        //loop 3
        for (i in eCol downTo sCol) {
            matrix[eRow][i] = count
            count++
        }
        eRow--

        //loop 4
        for (i in eRow downTo sRow) {
            matrix[i][sCol] = count
            count++
        }
        sCol++

    }

    return matrix
}


private fun matrixWithPattern(num: Int): MutableList<MutableList<String>> {

    val matrix = MutableList(num) { MutableList(num) { "" } }

    var sRow = 0
    var eRow = num - 1
    var sCol = 0
    var eCol = num - 1
    var count = 1

    while (sCol <= eCol && sRow <= eRow) {

        //loop 1
        for (i in sCol..eCol) {
            matrix[sRow][i] = "-"
            count++
        }
        sRow++

        //loop 2
        for (i in sRow..eRow) {
            matrix[i][eCol] = "\\"
            count++
        }
        eCol--

        //loop 3
        for (i in eCol downTo sCol) {
            matrix[eRow][i] = "-"
            count++
        }
        eRow--

        //loop 4
        for (i in eRow downTo sRow) {
            matrix[i][sCol] = "/"
            count++
        }
        sCol++

    }

    return matrix
}

















