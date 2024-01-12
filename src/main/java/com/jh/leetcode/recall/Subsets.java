package com.jh.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> banList = new ArrayList<>();
        int[] used = new int[nums.length];
        //如果找到了路径，加入
        findPath(nums, 0, new ArrayList<>());
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    private void findPath(int[] nums, int index, List<Integer> list) {
        //找到路径
        if (nums.length == index) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        //选择路径
        list.add(nums[index]);
        findPath(nums, index + 1, list);
        
        //撤销路径
        list.remove(list.size() - 1);
        findPath(nums, index + 1, list);
    }


}
