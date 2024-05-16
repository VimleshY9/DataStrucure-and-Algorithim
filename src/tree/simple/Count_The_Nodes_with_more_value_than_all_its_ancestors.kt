package tree.simple

import tree.IntNode

/*
* Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestors.
Ancestor means that every node that occurs before the current node in the path from root to the node.
* Input =>
*     4
   / \
  5   9
     / \
    11   10

* Output = 5
* */
var count = 0
fun solve(A: IntNode?): Int {
    solve(A, 0)
    return count
}

fun solve(A: IntNode?, max: Int) {
    var max = max
    if (A == null) {
        return
    }
    if (max < A.data) {
        max = A.data
        count++
    }
    solve(A.leftNode, max)
    solve(A.rightNode, max)
}


fun main(){
    val t1 = IntNode(4)
    t1.leftNode = IntNode(5)
    t1.rightNode = IntNode(9)
    t1.rightNode!!.leftNode = IntNode(11)
    t1.rightNode!!.rightNode = IntNode(10)
    solve(t1)
    println(count)
}