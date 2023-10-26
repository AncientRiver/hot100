package com.jh.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
* 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
* 你可以按任意顺序返回答案。
* */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.get(target - num);
            if (index!=null){
                return new int[]{index, i};
            }
            map.put(num,i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
