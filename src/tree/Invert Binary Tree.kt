package tree

class `Invert Binary Tree` {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        var leftNode = invertTree(root.left)
        var rightnode = invertTree(root.right)
        var temp = leftNode
        root.left = rightnode
        root.right = leftNode
        return root
    }
}
 class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }