import java.util.*

fun main() {

    val root = TNode(
        1, mutableListOf(
            TNode(
                2, mutableListOf(
                    TNode(5), TNode(6), TNode(
                        7, mutableListOf(
                            TNode(12)
                        )
                    )
                )
            ), TNode(
                3, mutableListOf(
                    TNode(8), TNode(9)
                )
            ), TNode(
                4, mutableListOf(
                    TNode(10), TNode(11)
                )
            )
        )
    )
//    bft(root)
//    println(
//        findLevelWidth(root).toString()
//    )

    println(
        levelWidth(root).toString()
    )

    val bstInvalid = BSTree.Node(
        value = 5,
        left = BSTree.Node(3),
        right = BSTree.Node(
            4, null, BSTree.Node(
                value = 6,
                left = BSTree.Node(7),
                right = BSTree.Node(8)
            )
        )
    )

    val bstValid = BSTree.Node(
        value = 5,
        left = BSTree.Node(
            value = 3,
            left = BSTree.Node(2),
            right = BSTree.Node(4)
        ),
        right = BSTree.Node(
            value = 7,
            left = BSTree.Node(value = 6),
            right = BSTree.Node(value = 8)
        )
    )

    println(isBstValid(bstValid))

}

//private fun bft(root: TNode) {
//    val queue: Queue<TNode> = LinkedList()
//    queue.add(root)
//    while (!queue.isEmpty()) {
//        val node = queue.poll()
//        println(node.value)
//        for (child in node.children) {
//            queue.add(child)
//        }
//    }
//}


class TNode<T>(
    val value: T, val children: MutableList<TNode<T>> = mutableListOf()
)


/**
 * Given the root node of a tree, return an array where each element is the width of the tree at each level.
 */
// Given:
//
//    0
//  / |  \
// 1   2   3
// |       |
// 4       5
// Answer: [1, 3, 2]

//1
//2 3 4
//5 6 7 8 9 10 11
//12
//1,-1,2,3,4,-1,5,6

fun levelWidth(root: TNode<Int>): List<Int> {
    val queue = mutableListOf(root)
    val levelWidths = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        levelWidths.add(queue.size)

        val children = mutableListOf<TNode<Int>>()
        for (node in queue) {
            children.addAll(node.children)
        }

        queue.clear()
        queue.addAll(children)
    }



    return levelWidths
}

//     5
//  3-----7
//2---4 6---8
private fun isBstValid(root: BSTree.Node<Int>?): Boolean {

    if (root == null) return true

    var min: BSTree.Node<Int>? = root
    var max: BSTree.Node<Int>? = root
    while (min != null && max != null) {

        if (min.value <= root.value && (min.left == null || min.left!!.value < min.value)) {
            min = min.left
        } else {
            return false
        }

        if (max.value >= root.value && (max.right == null || max.right!!.value > max.value)) {
            max = max.right
        } else {
            return false
        }

    }

    return true
}

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