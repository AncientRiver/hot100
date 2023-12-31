package com.jh.leetcode.tree;

/**
 * 二叉树高度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
