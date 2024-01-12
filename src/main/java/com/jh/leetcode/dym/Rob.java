package com.jh.leetcode.dym;

import java.util.HashMap;

/**
 * 跳着偷
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums.length > 1) {
            int[] costs = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                costs[i]=-1;
            }
            return Math.max(rob(nums, nums.length - 1, costs), rob(nums, nums.length - 2, costs));
        } else {
            return nums[0];
        }
    }

    public int rob(int[] nums, int index, int[] costs) {
        if (index < 0) {
            return 0;
        }
        if (index == 0 || index == 1) {
            return nums[index];
        }
        int sum3;
        if (index - 3 >= 0 && costs[index - 3] != -1) {
            sum3 = costs[index - 3];
        } else {
            sum3 = rob(nums, index - 3, costs);
            if (index-3>=0)costs[index - 3] = sum3;
        }


        int sum2;
        if (costs[index - 2] != -1) {
            sum2 = costs[index - 2];
        } else {
            sum2 = rob(nums, index - 2, costs);
            costs[index - 2] = sum2;
        }
        return Math.max(sum3, sum2) + nums[index];
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int rob = new Rob().rob(nums);
        System.out.println(rob);

    }
}
