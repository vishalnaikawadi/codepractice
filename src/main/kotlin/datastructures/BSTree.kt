package datastructures

class BSTree<T : Comparable<T>> {

    var root: Node<T>? = null

    data class Node<T : Comparable<T>>(
        var value: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    )

    fun isEmpty() = root == null

    fun insert(value: T) {
        val node = Node(value, null, null)

        if (isEmpty()) {
            root = node
        } else {
            var current = root
            while (true) {
                if (value < current!!.value) {
                    if (current.left == null) {
                        current.left = node
                        return
                    }
                    current = current.left
                } else {
                    if (current.right == null) {
                        current.right = node
                        return
                    }
                    current = current.right
                }
            }
        }
    }

    fun find(value: T): Node<T>? {
        var current = root
        while (current != null) {
            if (value == current.value) {
                return current
            } else if (value < current.value) {
                current = current.left
            } else {
                current = current.right
            }
        }
        return null
    }
}