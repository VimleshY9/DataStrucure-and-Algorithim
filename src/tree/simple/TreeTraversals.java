package tree.simple;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

//*
// Given a binary tree, return the inorder traversal of its nodes' values.
// Input: 
//  1
//  / \
// 6   2
//    /
//   3
// output - Inorder - 1 6 2 3. Preorder - 6 1 3 2. Postorder - 6 3 2 1, LevelOrder - 1 6 2 3
// */
public class TreeTraversals {
  ArrayList<Integer> nodes = new ArrayList<>();
  Queue<TNode> q = new ArrayDeque<>();
    public void getInorderTraversal(TNode node){
        if(node==null)return;
        nodes.add(node.val);
        getInorderTraversal(node.left);
        getInorderTraversal(node.right);
    }
    public void getPreorderTraversal(TNode node){
        if(node==null)return;
        getInorderTraversal(node.left);
        nodes.add(node.val);
        getInorderTraversal(node.right);
    }
    public void getPostorderTraversal(TNode node){
        if(node==null)return;
        getInorderTraversal(node.left);
        getInorderTraversal(node.right);
        nodes.add(node.val);
    }
    public void getLevelOrderTraversal(TNode node){
       q.add(node);
       while (!q.isEmpty()){
           TNode curr = q.poll();
            nodes.add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
       }
    }
    public static void main(String[] arg){
        TNode rootNode = new TNode(1);
        rootNode.left = new TNode(6);
        rootNode.right = new TNode(2);
        rootNode.right.left = new TNode(3);
        TreeTraversals traversal = new TreeTraversals();
//        traversal.getInorderTraversal(rootNode);
//        traversal.getPreorderTraversal(rootNode);
//        traversal.getPostorderTraversal(rootNode);
        traversal.getLevelOrderTraversal(rootNode);
        System.out.println(traversal.nodes);
    }
}

