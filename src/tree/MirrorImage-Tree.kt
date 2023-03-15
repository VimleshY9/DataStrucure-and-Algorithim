/*
* Q. Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
* example: Input: root = [1,2,2,3,4,4,3]
Output: true
* Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
*
* */

class `MirrorImage-Tree` {
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root?.left==null && root?.right==null) return true
        else
            return isMirrorImage(root?.left, root?.right)
    }

    private fun isMirrorImage(l: TreeNode?, r:TreeNode?): Boolean {
        if(l==null && r == null) return true
        if(l==null || r == null) return false
        return l.`val`== r.`val` && isMirrorImage(l?.left, r?.right) && isMirrorImage(l?.right, r?.left)
    }
}

 class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
         var right: TreeNode? = null
     }
