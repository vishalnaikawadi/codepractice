package algorithms

fun main() {

    val intArr = intArrayOf(4, 6, 8, -1, 8, 9, 3)
    print("Linear Search: ")
    println(linearSearch(intArr, -1))

    print("Binary Search: ")
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 6))
}


/**
 *Return index of matching target using Linear Search
 */
private fun linearSearch(arr: IntArray, target: Int): Int {

    for (i in arr.indices) {
        if (arr[i] == target) return i //exists at ith index
    }

    return -1 //doesn't exists
}

/**
 *Return the index of matching target using Binary Search if the array is sorted in ascending order.
 */
private fun binarySearch(arr: IntArray, target: Int): Int {

    var min = 0
    var max = arr.lastIndex

    while (min <= max) {
        val mid = (max + min) / 2

        when {
            target == arr[mid] -> return mid
            target < arr[mid] -> max = mid - 1
            target > arr[mid] -> min = mid + 1
        }
    }

    return -1 //doesn't exists
}