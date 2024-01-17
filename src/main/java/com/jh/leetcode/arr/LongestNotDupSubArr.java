package com.jh.leetcode.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长无重复子数组
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 */
public class LongestNotDupSubArr {
    public static int maxLength(int[] arr) {
        // write code here
        if (arr.length == 1) return 1;

        int maxLength = 0;

        int start = 0, end = 0;
        Set<Integer> set = new HashSet<>();
        while (end != arr.length) {
            if (!set.contains(arr[end])) {
                set.add(arr[end]);
                end++;
            } else {
                maxLength = Math.max(maxLength, end - start);
                start++;
                end = start ;
                set.clear();
            }
        }
        maxLength = Math.max(maxLength, end - start);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{3, 3, 3, 3, 3}));
    }
}
