package com.jh.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 层级遍历
 */
public class LayerIterate {


    public static List<List<Integer>> layerIterate(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root!=null){
            result.add(new ArrayList<Integer>(){{add(root.val);}});
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (treeNode.left != null) treeNodes.add(treeNode.left);
            if (treeNode.right != null) treeNodes.add(treeNode.right);
            if (queue.isEmpty()) {
                queue.addAll(treeNodes);
                List<Integer> copyList = treeNodes.stream().map(node -> node.val).collect(Collectors.toList());
                if (!copyList.isEmpty()) {
                    result.add(copyList);
                }
                treeNodes.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(layerIterate(root));
    }
}
