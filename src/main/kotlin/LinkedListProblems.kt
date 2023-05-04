import datastructures.KLinkedList

fun main() {

    val kList = KLinkedList<Int>()
    kList.addLast(1)
    kList.addLast(2)
    kList.addLast(3)
    kList.addLast(4)
    kList.addLast(5)
    kList.addLast(6)
    kList.addLast(7)
    kList.addLast(8)
    kList.addLast(9)
    kList.addLast(10)
//    println(findMidPoint(kList))

//    val kList2 = datastructures.KLinkedList<Int>()
//    val a = datastructures.KLinkedList.Node(1, null)
//    val b = datastructures.KLinkedList.Node(2, null)
//    val c = datastructures.KLinkedList.Node(3, null)
//    val d = datastructures.KLinkedList.Node(4, null)
//    kList2.head = a
//    a.next = b
//    b.next = c
//    c.next = d
//    d.next = null
//    println(findIfItIsCircular(kList2))

    println(fromLast(kList, 3))

}


/**
 * Return the 'middle' node of a linked list.
 *
 * If the list has an even number of elements return the node at the end of the first half of the list.
 *
 * Do not use a counter variable
 *
 * Do not retrieve the size of the list
 *
 * Only iterate through the list one time
 */
private fun findMidPoint(list: KLinkedList<String>): String {

    var slow = list.head
    var fast = list.head

    while (fast?.next?.next != null) {

        slow = slow?.next
        fast = fast.next?.next

    }

    return slow?.value ?: "NA"
}


/**
 * Given a linked list, return true if the list is circular, false if it is not.
 */
private fun findIfItIsCircular(list: KLinkedList<Int>): Boolean {

    var slow = list.head
    var fast = list.head

    while (fast?.next?.next != null) {

        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }

    }

    return false
}


/**
 * Given a linked list and integer n, return the element n spaces from the last node in the list.
 *
 * Do not call the 'size' method of the linked list
 *
 * Assume that n will always be less than the length of the list.
 */
//const list = new LinkedList();
//
//   list.insertLast('a');
//   list.insertLast('b');
//   list.insertLast('c');
//   list.insertLast('d');
//
//   fromLast(list, 2).data // 'b'

private fun fromLast(list: KLinkedList<Int>, n: Int): Int? {

    var slow = list.head
    var fast = list.head

    for (i in 0 until n) {
        fast = fast?.next
    }

    while (fast != null) {

        fast = fast.next
        if (fast == null) break
        slow = slow?.next

    }

    return slow?.value
}


