package com.jh.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由小写字母组成的长度为n的字符串 S ，找出所有长度为 k 且包含重复字符的子串，请你返回全部满足要求的子串的数目。
 */
public class NumKLenSubstrRepeats {
    //滑动窗口思想
    public static int numKLenSubstrRepeats(String s, int k) {
        // write code here
        int start = 0;
        int end = start + k-1;
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end != s.length()) {
            for (int i = start; i <= end; i++) {
                if (map.containsKey(s.charAt(i))) {
                    sum += 1;
                    break;
                }
                map.put(s.charAt(i),1);
            }
            map.clear();
            start++;
            end++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numKLenSubstrRepeats("ababab", 3));
    }
}
