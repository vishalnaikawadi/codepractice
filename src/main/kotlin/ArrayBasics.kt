//Merge sorted Array
//input: [0,3,4,31] , [4,6,30]
//output: [0,3,4,4,6,30,31]

fun mergeSortedArrays(arr1: IntArray, arr2: IntArray): IntArray {
    val sortedArr = arr1 + arr2
    sortedArr.sort()
    return sortedArr
}

//Two Sums
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Input: nums = [3,2,4], target = 6
//Output: [1,2]

fun calculateTwoSums(arr: IntArray, target: Int): IntArray {
    val numMap = hashMapOf<Int, Int>()

    for (i in 0..arr.lastIndex) {

        if (numMap.contains(arr[i])) {

            return intArrayOf(numMap[arr[i]]!!, i)
        }

        val remain = target - arr[i]
        numMap[remain] = i
    }

    return intArrayOf()
}

//Maximum subarray, largest sum
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
/**
 * NOT COMPLETED
 */
fun maximumSumArray(arr: IntArray): IntArray {

    arr.sort()
    print(arr.contentToString())

    return intArrayOf()
}

//input: [2,5,1,2,3,5,1,2]
//output: 2
fun findFirstRecurring(arr: IntArray): Int { //O(n)

    val recSet = mutableSetOf<Int>()

    for (i in 0..arr.lastIndex) {
        if (recSet.contains(arr[i])) {
            return arr[i]
        }
        recSet.add(arr[i])
    }

    return 0
}


//sort manually
//input: [2,5,1,21,3,7,31]
//        0,1,2,3 ,4,5,6
//output: 2

fun sortTheArray(arr: IntArray): IntArray {

    val newArr = mutableListOf<Int>()

    for (i in 0..arr.lastIndex) {
        val nextIndex = if (i < arr.lastIndex) i + 1 else 0
        if (nextIndex != 0) {
            if (arr[i] < arr[nextIndex]) {
                newArr.add(0, arr[i])
            } else {
                newArr.add(0, arr[nextIndex])
            }
        }
    }

    println(newArr)

    return newArr.toIntArray()
}


//Unique Number of Occurrences
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

/**
 * IMPORTANT
 */
fun uniqueOccurrences(arr: IntArray): Boolean {

    val hashMap = hashMapOf<Int, Int>() //to store number as a key and occurrences as a value
    val hashSet = HashSet<Int>() //to create unique set of occurrences

    for (i in 0..arr.lastIndex) {
        hashMap[arr[i]] = (hashMap[arr[i]] ?: 0) + 1 //if key doesn't exist add 1 else add previous value + 1
    }

    hashMap.forEach {
        hashSet.add(it.value) //same values in hashmap will be added only once in the hashset automatically
    }

    //if hashset size is different, means hashmap contains multiple same values
    //and if hashmap contains multiple same values then it's size will always be greater than hashset.size
    return hashMap.size == hashSet.size
}

fun findSumOfAllArrayElements(arr: IntArray): Int {
    var total = 0

    for (a in arr)
        total += a

    return total
}

fun largestNumberInArray(arr: IntArray): Int {

    arr.sortDescending()

    return arr.get(index = 0)
}

fun `remove all occurences of specific element from the array`(arr: IntArray, element: Int): IntArray {

    var newArr = intArrayOf()
    for (i in 0..arr.lastIndex) {
        if (element != arr[i]) {
            newArr = newArr.plus(arr[i])
            println(arr[i])
        }
    }

    return newArr
}

fun `find the minimum or maximum value in an array`(arr: IntArray, findMinimum: Boolean): Int {

    if (findMinimum) arr.sort() else arr.sortDescending()


    return arr[0]
}

fun `remove duplicates from an array`(arr: IntArray): IntArray {

    return arr.toSet().toIntArray()
}

fun `reverse an array`(arr: IntArray): IntArray {

    var newArr = IntArray(0)
    for (i in arr.lastIndex downTo 0) {

        newArr = newArr.plus(arr[i])
    }

    return newArr
}

fun main() {

//    println(maximumSumArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)).contentToString())
//    println(findFirstRecurring(intArrayOf(2, 5, 1, 3, 3, 5, 1, 2)))

//    println(sortTheArray(intArrayOf(2, 5, 1, 21, 3, 7, 31)).contentToString())
//    println(selectionSort(intArrayOf(-2, 54, 1, 221, 5, 88, 31)).contentToString())
//    println(insertionSort(intArrayOf(2, 3, 5, 6, 1, 7, 8, 4)).contentToString())
//    println(uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3, 3)))
//    println(findSumOfAllArrayElements(intArrayOf(1, 5, 6, 8, 9)))
//    println(largestNumberInArray(intArrayOf(1, 5, 10, 8, 9)))
//    println(`remove all occurences of specific element from the array`(intArrayOf(1, 5, 10, 8, 9), 9).contentToString())
//    println(`find the minimum or maximum value in an array`(intArrayOf(1, 5, 10, 8, 9), false))
//    println(`remove duplicates from an array`(intArrayOf(1, 4, 3, 4, 1, 2)).contentToString())
//    println(`reverse an array`(intArrayOf(1, 4, 3, 4, 1, 2)).contentToString())
}