import com.sun.source.tree.BinaryTree
import java.util.LinkedList
import java.util.Queue

fun main() {

    val stack = Stack<Int>()
    stack.push(10)
    stack.push(20)
    stack.push(30)
    stack.push(40)
    println(stack.print())


}

//[new][head][2][3][4][tail]
data class Node<V>(var value: V, var next: Node<V>? = null)


class Stack<T>(
    private var top: Node<T>? = null,
    private var bottom: Node<T>? = null,
    private var length: Int = 0
) {

    fun peek(): Node<T>? {
        return top
    }

    fun push(value: T) {
        val node = Node(value)
        if (length == 0) {
            top = node
            bottom = node
        } else {
            node.next = top
            top = node
        }
        length++
        println("node: ${node}")
    }

    fun pop() {}

    fun print() {

        if (length == 0) print("") else {
            var next = top
            while (next != null) {
                print("${next.value}, ")
                next = next.next
            }

        }

    }

}
