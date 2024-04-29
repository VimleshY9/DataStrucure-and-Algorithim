package tree.simple

import tree.Node

/*
* Q. binary tree is give, and you need to find out the size of a tree => size = number of nodes in the
* Tips => size of a tree = 1 + number of nodes in left subtree + number of nodes in right subtree.
* Input =>
*        1
        / \
       2   5
      / \   \
     3   4   6
* Output => 6
* TC => O(N) = for calculating it should visit to each node
* SC => O(H) - H=height of a tree => we are using recursion to solve the issue, so it any point of time it will have the maximum H
* number of elements in stack
* */

fun calculateSize(node: Node?):Int{
if(node == null) return 0
    val leftSubTree =  calculateSize(node.leftNode)
    val rightSubTree = calculateSize(node.rightNode)
    return 1+leftSubTree+rightSubTree

}

fun main(){
    val rootNode = Node(1)
    rootNode.leftNode = Node(2)
    rootNode.leftNode?.leftNode = Node(3)
    rootNode.leftNode?.rightNode = Node(4)

    rootNode.rightNode = Node(5)
    rootNode.rightNode?.rightNode = Node(6)
    println(calculateSize(rootNode))
}