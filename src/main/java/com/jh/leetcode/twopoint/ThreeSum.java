package com.jh.leetcode.twopoint;

import java.util.*;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = -nums[i];
            Set set = new HashSet();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(sum - nums[j])) {
                    list.add(Arrays.asList(nums[i], sum - nums[j], nums[j]));
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return list;
    }
}