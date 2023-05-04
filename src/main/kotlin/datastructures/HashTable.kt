package datastructures

import java.util.*

class HashTable<K, V>(private val capacity: Int) {
    private val table = Array<LinkedList<Entry<K, V>>>(capacity) { LinkedList() }

    fun put(key: K, value: V) {
        val index = getIndex(key)
        table[index].forEach {
            if (it.key == key) {
                it.value = value
                return
            }
        }
        table[index].add(Entry(key, value))
    }

    fun get(key: K): V? {
        val index = getIndex(key)
        table[index].forEach {
            if (it.key == key) {
                return it.value
            }
        }
        return null
    }

    fun remove(key: K) {
        val index = getIndex(key)
        val iterator = table[index].iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (entry.key == key) {
                iterator.remove()
                return
            }
        }
    }

    private fun getIndex(key: K): Int {
        return key.hashCode() % capacity
    }

    private data class Entry<K, V>(val key: K, var value: V)
}
