package com.jh.leetcode.recall;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 全排列问题
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute_2 {

    public List<List<Integer>> permute(int[] nums) {

        permuteList(nums, 0);
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    private void permuteList(int[] nums, int index) {
        if (index == nums.length) {
            lists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, index, i);
            permuteList(nums, index + 1);
            swap(nums, index, i);

        }
    }

    private boolean exists(int[] nums, int currentIndex, int num) {
        for (int i = 0; i < currentIndex; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        Permute_2 permute = new Permute_2();
        System.out.println(permute.permute(new int[]{1, 1, 2, 3}));
    }

}
