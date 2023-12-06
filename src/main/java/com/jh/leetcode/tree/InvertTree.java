package com.jh.leetcode.tree;

public class InvertTree {
    public TreeNode invertTree(TreeNode treeNode) {
        if (treeNode == null) return null;
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
        invertTree(treeNode.left);
        invertTree(treeNode.right);
        return treeNode;
    }
}
