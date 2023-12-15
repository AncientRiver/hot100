package com.jh.leetcode.tree;

import java.util.Objects;
import java.util.Optional;

/**
 * 是否为镜像树
 */
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode treeNode) {

        return isSymmetric(treeNode.left, treeNode.right);
    }

    public static boolean isSymmetric(TreeNode leftTreeNode, TreeNode rightTreeNode) {
        if (leftTreeNode == rightTreeNode) return true;
        if (leftTreeNode == null || rightTreeNode == null) return false;
        if (leftTreeNode.val != rightTreeNode.val) return false;
        boolean flag1 = isSymmetric(leftTreeNode.left, rightTreeNode.right);
        boolean flag2 = isSymmetric(leftTreeNode.right, rightTreeNode.left);
        return flag1 && flag2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
