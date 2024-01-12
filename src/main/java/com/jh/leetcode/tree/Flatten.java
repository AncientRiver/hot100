package com.jh.leetcode.tree;


public class Flatten {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        flatten(root);
        System.out.println(root);
    }

    public static void flatten(TreeNode root) {
        if (root==null)return;
        TreeNode treeNode = new TreeNode(0);
        flatten(root,treeNode);
        root.left=null;
        root.right=treeNode.right.right;
    }

    public static TreeNode flatten(TreeNode root, TreeNode newTreeNode) {
        if (root==null)return newTreeNode;
        TreeNode treeNode=new TreeNode(root.val);
        newTreeNode.right=treeNode;

        treeNode=flatten(root.left,treeNode);
        
        return flatten(root.right,treeNode);
    }

}
