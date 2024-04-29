package tree.simple

import tree.Node
import kotlin.math.max

/*
* Q. we have given a binary tree, you need to find out the height of a binary tree
*  => height: the farthest/lowest node or leaf node you can reach from the current node it's  that will be height of your current node.
* Tips => height => 1 + max (left subtree height , right subtree height)
* Input =>
*        1
        / \
       2   5
      / \   \
     3   4   6
* Output => 3
* TC => O(N) => you have to visit each node to find out, what is the lowest node
* SC => O(H)
* */

fun calculateHeight(node: Node?):Int{
    if (node == null) return 0
    val lst = calculateHeight(node.leftNode)
    val rst = calculateHeight(node.rightNode)
    return 1 + max(lst, rst)
}

fun main(){
    val node = Node(1)
    node.leftNode = Node(2)
    node.leftNode?.leftNode = Node(3)
    node.leftNode?.rightNode = Node(4)

    node.rightNode = Node(5)
    node.rightNode?.rightNode = Node(6)
    println(calculateHeight(node))
}