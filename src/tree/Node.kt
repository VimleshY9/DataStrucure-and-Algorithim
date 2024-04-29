package tree

data class Node(val data: Any, var leftNode:Node? = null, var rightNode: Node? = null)
