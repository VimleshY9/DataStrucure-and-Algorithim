package tree.simple

import tree.Node

/*
* Q. you have give a Binary tree, containing all the unique values. you need to find the path from the root to the node of value K
* Tips => there are two thinks you need to find out, 1. the K and 2. path from the root to the node K.
*         you need to keep the track of the path while finding the node so that once you find the node, you can return that path.
* Input => k = 6
*        1
        / \
       2   5
      / \   \
     3   4   6
* Output => 1 -> 5 -> 6 => this should be the path (you need to return the list of element in a proper sequence from root to that node of value K)
* TC = O(N)
* SC = O(H)
* */

var list = arrayListOf<Any?>()
var ans = arrayListOf<Any?>()

fun findPath(node: Node?, k:Int){
    if (node == null) return
    val value = node.data
    list.add(value)
    if (value == k){
        ans.addAll(list)
        return
    }
    findPath(node.leftNode, k)
    findPath(node.rightNode, k)
    list.removeLast()
}
fun main(){
    val node = Node(1)
    node.leftNode = Node(2)
    node.leftNode?.leftNode = Node(3)
    node.leftNode?.rightNode = Node(4)

    node.rightNode = Node(5)
    node.rightNode?.rightNode = Node(6)
    findPath(node, 6)
    println(ans)
}