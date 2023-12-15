package com.jh.leetcode.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉树的直径，二叉树中任意两个结点的最长距离
 */
public class DiameterOfBinaryTree {

    public  int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger max=new AtomicInteger(0);
        maxDeep(root,max);
        return max.get();
    }

    public int maxDeep(TreeNode node, AtomicInteger max){
        if (node==null)return 0;
        int left = maxDeep(node.left,max);
        int right = maxDeep(node.right,max);
        max.set(Math.max(max.get(),left+right));
        return Math.max(left,right)+1;
    }
}
