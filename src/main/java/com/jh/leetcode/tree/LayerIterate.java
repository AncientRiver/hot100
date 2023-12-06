package com.jh.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

/**
 * 层级遍历
 */
public class LayerIterate {
    public static boolean layerIterate(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();

            if (treeNode.left!=null) queue.offer(treeNode.left);
            if (treeNode.right!=null) queue.offer(treeNode.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

    }
}
