package com.jh.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列问题
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> numList = new ArrayList<>();
            numList.add(nums[i]);
            lists.addAll(permuteList(nums, numList));
        }
        return lists;
    }

    private List<List<Integer>> permuteList(int[] nums, List<Integer> numList) {
        if (numList.size() == nums.length) return Collections.singletonList(numList);
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (numList.contains(nums[i])) continue;
            List<Integer> copyList = new ArrayList<>();
            copyList.addAll(numList);
            copyList.add(nums[i]);
            lists.addAll(permuteList(nums, copyList));
        }
        return lists;
    }

    public static void main(String[] args) {
        Permute permute=new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3,4}));
    }

}
