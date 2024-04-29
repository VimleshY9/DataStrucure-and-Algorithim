package tree.simple

import tree.Node

/*
* Q. you have give a binary tree of unique values, you need to find out if K (given value/no) exist in a given binary tree
* Tips => for finding a node of a given value, we have to visit each node, it could be the root node, the lowest leaf node, or
* any middle node.
* Input => find k=4 exist or not - return true if exist
*        1
        / \
       2   5
      / \   \
     3   4   6
* Output => true
* TC = O(N)
* SC = O(H)
* */

fun isKExist(node: Node?, k:Int):Boolean{
    if(node == null) return false
    val value = node.data
    if(value == k) return true
    return isKExist(node.leftNode, k)  || isKExist(node.rightNode, k)
}
fun main(){
    val node = Node(1)
    node.leftNode = Node(2)
    node.leftNode?.leftNode = Node(3)
    node.leftNode?.rightNode = Node(4)

    node.rightNode = Node(5)
    node.rightNode?.rightNode = Node(6)
    println(isKExist(node, 4))
}