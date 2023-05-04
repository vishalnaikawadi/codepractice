package datastructures

class Queue<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun enqueue(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        size++
    }

    fun dequeue(): T? {
        if (head == null) {
            return null
        }
        val value = head?.value
        head = head?.next
        if (head == null) {
            tail = null
        }
        size--
        return value
    }

    fun isEmpty() = size == 0

    fun size() = size

    private inner class Node<T>(val value: T) {
        var next: Node<T>? = null
    }
}
