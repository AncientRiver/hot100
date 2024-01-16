package com.jh.leetcode.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallest {
    int index = 0;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        kthSmallest(root.left, k);
        if (index == k - 1) {
            val = root.val;
        }
        if (++index > k) return val;
        kthSmallest(root.right, k);
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new KthSmallest().kthSmallest(root, 3));
    }
}
