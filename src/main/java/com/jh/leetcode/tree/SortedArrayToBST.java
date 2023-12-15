package com.jh.leetcode.tree;

/**
 * 有序数组转高度平衡的二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0, end = nums.length-1;
        return findMiddleNode(start, end, nums);
    }

    public TreeNode findMiddleNode(int start, int end, int[] nums) {
        if (start > end) return null;
        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode();
        treeNode.val = nums[middle];
        treeNode.left = findMiddleNode(start, middle-1, nums);
        treeNode.right = findMiddleNode(middle+1, end, nums);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] p = new int[]{-10, -3, 0, 5, 9};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode treeNode = sortedArrayToBST.sortedArrayToBST(p);
        System.out.println(1);

    }
}
