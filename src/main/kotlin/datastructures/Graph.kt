package datastructures

class Graph<T> {
    private val adjacencyList = mutableMapOf<T, MutableList<T>>()

    fun addVertex(vertex: T) {
        adjacencyList[vertex] = mutableListOf()
    }

    fun addEdge(from: T, to: T) {
        adjacencyList[from]?.add(to)
        adjacencyList[to]?.add(from)
    }

    fun removeVertex(vertex: T) {
        adjacencyList[vertex]?.let { neighbors ->
            neighbors.forEach {
                adjacencyList[it]?.remove(vertex)
            }
            adjacencyList.remove(vertex)
        }
    }

    fun removeEdge(from: T, to: T) {
        adjacencyList[from]?.remove(to)
        adjacencyList[to]?.remove(from)
    }

    fun getNeighbors(vertex: T): List<T>? {
        return adjacencyList[vertex]
    }

    fun getAllVertices(): Set<T> {
        return adjacencyList.keys
    }

    fun isEmpty(): Boolean {
        return adjacencyList.isEmpty()
    }
}
