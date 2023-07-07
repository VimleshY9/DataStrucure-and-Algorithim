package tree

/*
* Q. Given a binary tree, determine if it is height-balanced
.....................................................
*Input: root = [3,9,20,null,null,15,7]
Output: true
* ..............................
* TC = O(n)
* */
class `Balanced Binary Tree` {
    fun isBalanced(root: TreeNode?): Boolean {
        if(root==null) return true
        return Math.abs(getHeight(root?.left) - getHeight(root?.right))<=1 && isBalanced(root?.left) && isBalanced(root?.right)
    }

    fun getHeight(root: TreeNode?):Int{
        if(root==null) return 0
        return 1+Math.max(getHeight(root?.left), getHeight(root?.right))
    }
}

