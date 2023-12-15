package com.jh.leetcode.twopoint;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int start = 0, end = 0;
        while (start < nums.length && end < nums.length) {
            if (nums[start] == 0 && nums[end] != 0) {
                swap(nums, start, end);
            }
            if (nums[start] != 0) {
                start++;
            }
            if (nums[end] == 0) {
                end++;
            }
            if (start > end) {
                end = start;
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1, 0};
        moveZeroes(target);
        System.out.println(Arrays.toString(target));
    }
}
