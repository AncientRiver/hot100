package com.jh.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 中序遍历
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        left.add(root.val);
        left.addAll(right);
        return left;
    }

}
