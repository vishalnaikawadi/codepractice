package datastructures

class Stack<T> {
    private val elements = mutableListOf<T>()

    fun push(element: T) {
        elements.add(element)
    }

    fun pop(): T? {
        if (elements.isEmpty()) {
            return null
        }
        return elements.removeAt(elements.size - 1)
    }

    fun peek(): T? {
        if (elements.isEmpty()) {
            return null
        }
        return elements[elements.size - 1]
    }

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size
}
