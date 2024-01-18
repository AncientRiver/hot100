package com.jh.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列问题
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> valueList = new ArrayList<>();
            valueList.add(nums[i]);
            List<Integer> indexList = new ArrayList<>();
            indexList.add(i);
            permuteList(nums, indexList, valueList);
        }
        return arr;
    }

    List<List<Integer>> arr = new ArrayList<>();

    public void permuteList(int[] nums, List<Integer> indexList, List<Integer> list) {
        if (list.size() == nums.length) {
            arr.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if (indexList.contains(i)) continue;
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[i]);
            List<Integer> newIndexList = new ArrayList<>(indexList);
            newIndexList.add(i);
            permuteList(nums, newIndexList, newList);
        }
    }

    public static void main(String[] args) {
        Permute2 permute = new Permute2();
        System.out.println(permute.permuteUnique(new int[]{1, 2, 3, 4}));
    }

}
