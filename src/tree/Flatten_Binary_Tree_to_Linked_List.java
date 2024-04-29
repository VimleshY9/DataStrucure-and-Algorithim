package tree;
/*
* Q. Given a binary tree A, flatten it to a linked list in-place.
The left child of all nodes should be NULL.
* .............................................
* Problem Constraints
1 <= size of tree <= 100000
* ..................................
* Input =>
*        1
        / \
       2   5
      / \   \
     3   4   6
*Output =>
*
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
* .............................
* TC => O(n)
*
* */


public class Flatten_Binary_Tree_to_Linked_List {
    public TreeNode1 flattenTheTree(TreeNode1 a) {
        TreeNode1 head = a;
        flatten(a);
        return head;
    }
    public void flatten(TreeNode1 root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            flatten(root.left);
        }

        if (root.right != null) {
            flatten(root.right);
        }

        TreeNode1 rightSubtree = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode1 current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = rightSubtree;
    }

}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) {
        val = x;
    }
}