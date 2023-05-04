package datastructures

class KLinkedList<T> {

    var head: Node<T>? = null


    fun isEmpty(): Boolean = head == null

    fun size(): Int {
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    fun get(index: Int): Node<T>? {
        return if (index < 0 || index >= size()) {
            null
        } else {
            var current = head
            repeat(index) {
                current = current?.next
            }
            current
        }
    }


    fun addFirst(value: T) {
        head = Node(value, head)
    }

    fun addLast(value: T) {
        val newNode = Node(value, null)
        if (isEmpty()) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    //just for testing
    fun addLast(value: T, node: Node<T>? = null) {
        val newNode = Node(value, node)
        if (isEmpty()) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun removeFirst(): T? {
        return if (isEmpty()) {
            null
        } else {
            val removedValue = head?.value
            head = head?.next
            removedValue
        }
    }

    override fun toString(): String {
        val values = mutableListOf<T>()
        var current = head
        while (current != null) {
            values.add(current.value)
            current = current.next
        }
        return values.joinToString(" -> ")
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?
    )
}
