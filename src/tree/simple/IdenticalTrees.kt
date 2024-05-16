package tree.simple

import tree.Node

/*
*Q.  Given two binary trees, check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*Input 1:

   1       1
  / \     / \
 2   3   2   3
 *
 * Tips: for proving the trees identical you need to travers the tree at the same time and using same traver method and
 * just by comparing the value of the corresponding node, you can tell, trees are identical or not
*
* */

fun isTreesIdentical(t1: Node?, t2: Node?):Boolean{
    if(t1==null && t2==null)return true
    if (t1==null || t2==null) return false
   return t1.data == t2.data && isTreesIdentical(t1.leftNode, t2.leftNode) &&
        isTreesIdentical(t1.rightNode, t2.rightNode)
}

fun main(){
    val t1 = Node(1)
    t1.leftNode = Node(2)
    t1.rightNode = Node(3)
    val t2 = Node(1)
    t2.leftNode = Node(2)
    t2.rightNode = Node(3)
    println(isTreesIdentical(t1, t2))
}