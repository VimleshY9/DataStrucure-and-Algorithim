package tree

data class Node(val data: Any, var leftNode:Node? = null, var rightNode: Node? = null)
data class IntNode(val data: Int, var leftNode:IntNode? = null, var rightNode: IntNode? = null)
