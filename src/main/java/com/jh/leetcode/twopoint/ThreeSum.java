package com.jh.leetcode.twopoint;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
class ThreeSum {
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            int sum = -nums[i];
//            Set set = new HashSet();
//
//            for (int j = i + 1; j < nums.length; j++) {
//                if (set.contains(sum - nums[j])) {
//                    List<Integer> iList = Arrays.asList(nums[i], sum - nums[j], nums[j]);
//                    Collections.sort(iList);
//                    list.add(iList);
//                } else {
//                    set.add(nums[j]);
//                }
//            }
//        }
//        return list.stream().distinct().collect(Collectors.toList());
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = nums.length - 1;
//            while (start < nums.length - 2 && nums[start + 1] == nums[start]) start++;
//            while (end > i && nums[end - 1] == nums[end]) end--;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < nums.length - 2 && nums[start + 1] == nums[start]) start++;
                    while (end > i && nums[end - 1] == nums[end]) end--;
                    start++;
                    end--;
                    continue;
                }
                if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, -1, 1, -1, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}