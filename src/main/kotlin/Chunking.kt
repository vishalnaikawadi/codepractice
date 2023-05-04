/**
 * Given an array and chunk size, divide the array into many subarrays where each subarray is of the provided size.
 */

fun main() {

//    arrayChunk(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 2)
    println(
        arrayChunkUsingSlice(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 2).toString()
    )
    println(
        arrayChunkUsingSlice2(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8), 2).toString()
    )
}

//[1,2,4,5,6,7,8,9] (2) = [1,2][4,5][6,7],[8,9]
//[0,1,2,3,4,5,6,7]
private fun arrayChunk(arr: IntArray, size: Int) {

    val chunked = mutableListOf<MutableList<Int>>() //create a list to store list of integers

    for (i in arr.indices) { //iterate through the input array

        //get the last item from chunked if exists, else return new mutable list.
        val last = if (chunked.isNotEmpty()) {
            chunked.last()
        } else mutableListOf()

        if (last.isEmpty() || last.size == size) { //add item to chunked only when last is empty or until last.size becomes equal to provided size
            chunked.add(
                mutableListOf(arr[i])
            )
        } else {
            last.add(arr[i]) //else add item to last array from chunked.
        }
    }

    println(chunked.toString())
}

//this solution took me longer time than expected even though I know the hint
private fun arrayChunkUsingSlice(arr: IntArray, size: Int): List<List<Int>> {

    val chunked = mutableListOf<List<Int>>()
    if (size >= arr.size || size <= 0) {
        chunked.add(arr.toList())
        return chunked //return original array content if size is negative or greater that actual array size
    }

    var start = 0 //to decide the starting point of slice
    var end = size - 1 //to decide the end point of slice
    var last = arr.lastIndex //to decide number of iterations

    while (last >= 0) {

        chunked.add(arr.slice(start..end))
        start += size
        end = if ((end + size) > arr.lastIndex)
            arr.lastIndex
        else
            (end + size) //if end becomes end > lastIndex, use the lastIndex value instead to avoid exceptions
        last -= size
    }

    return chunked
}

private fun arrayChunkUsingSlice2(arr: IntArray, size: Int): List<List<Int>> {

    val chunked = mutableListOf<List<Int>>()

    var start = 0 //to decide the starting point of slice

    while (start < arr.lastIndex) {
        chunked.add(arr.slice(start..(start + size)))
        start = if ((start + size) > arr.lastIndex)
            arr.lastIndex
        else
            (start + size) //if end becomes end > lastIndex, use the lastIndex value instead to avoid exceptions

    }

    return chunked
}