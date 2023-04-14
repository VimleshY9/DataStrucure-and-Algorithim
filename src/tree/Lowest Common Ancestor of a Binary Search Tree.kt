package tree

/*
* Q. Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
* ...........................................
* Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
* ......................................
* TC = O(n)
*
* */
class `Lowest Common Ancestor of a Binary Search Tree` {
        fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            if(root?.`val`!! > p?.`val`!! && root?.`val`!! < q?.`val`!!) return root
            if(root?.`val`!! > q?.`val`!! && root?.`val`!! < p?.`val`!!) return root

            var path1 = ArrayList<TreeNode?>()
            var path2 = ArrayList<TreeNode?>()
            getPath(root, p, path1)
            getPath(root, q, path2)
            var ans:TreeNode? = null
            for(i in 0..Math.min(path1.size, path2.size)-1){
                if(path1[i]==path2[i]){
                    ans = path1[i]
                }
            }
            return ans
        }
        fun getPath(root: TreeNode?, node:TreeNode?, path:ArrayList<TreeNode?>){
            if(root==null)return
            path.add(root)
            if(root!!.`val` == node!!.`val`) return

            if(node!!.`val`>root!!.`val` )
            { getPath(root?.right, node, path)
                return
            }
            else if(node.`val`< root.`val`)
            {
                getPath(root?.left, node, path)
                return
            }
            path.removeAt(path.size - 1)
            return
        }
}