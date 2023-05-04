fun main() {

    val arrToBeSorted = intArrayOf(-2, 54, 1, 221, 5, 88, 31)
    println("Bubble    : ${bubbleSort(arrToBeSorted).contentToString()}")
    println("Selection : ${selectionSort(arrToBeSorted).contentToString()}")
    println("Insertion : ${insertionSort(arrToBeSorted).contentToString()}")
    println("Merge     : ${mergeSort(arrToBeSorted).contentToString()}")

}

/**
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
private fun bubbleSort(arr: IntArray): IntArray {

    for (i in 0..arr.lastIndex) {
        for (j in 0 until arr.lastIndex - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

/**
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
fun selectionSort(arr: IntArray): IntArray {

    for (i in 0..arr.lastIndex) {
        for (j in i..arr.lastIndex) {

            var tmp: Int
            if (arr[i] > arr[j]) {
                tmp = arr[j]
                arr[j] = arr[i]
                arr[i] = tmp
            }

        }
    }

    return arr
}

/**
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
fun insertionSort(arr: IntArray): IntArray {

    for (i in 0..arr.lastIndex) {
        for (j in 0..arr.lastIndex) {
            if (arr[i] < arr[j]) {
                val tmp = arr[j]
                arr[j] = arr[i]
                arr[i] = tmp
                continue
            }
        }
    }

    return arr
}

/**
 * Time Complexity: O(n log n)
 */
fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) {
        return arr
    }

    val mid = arr.size / 2
    val left = arr.copyOfRange(0, mid)
    val right = arr.copyOfRange(mid, arr.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var i = 0
    var j = 0
    var k = 0

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result[k++] = left[i++]
        } else {
            result[k++] = right[j++]
        }
    }

    while (i < left.size) {
        result[k++] = left[i++]
    }

    while (j < right.size) {
        result[k++] = right[j++]
    }

    return result
}

