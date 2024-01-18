package com.jh.leetcode.string;

/**
 * 定义重复字符串是由两个相同的字符串首尾拼接而成。例如："abcabc" 是一个长度为 6 的重复字符串，因为它由两个 "abc" 串拼接而成；"abcba" 不是重复字符串，因为它不能由两个相同的字符串拼接而成。
 * <p>
 * 给定一个字符串，请返回其最长重复子串的长度。
 * <p>
 * 若不存在任何重复字符子串，则返回 0。
 */
public class LongestDupSubstring {

    public static String longestDupSubstring(String s) {
        String longestStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= (s.length() - i) / 2; j++) {
                if (s.substring(i, j + i).equals(s.substring(j + i, i + 2 * j))) {
                    String substring = s.substring(i, i + 2 * j);
                    if (substring.length() > longestStr.length()) {
                        longestStr = substring;
                    }
                }
            }
        }
        return longestStr;
    }

/*
    //该算法在递归过程中会超时
    public static String longestDupSubstring(String s) {
        String longestStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= (s.length() - i) / 2; j++) {
                if (s.substring(i, j + i).equals(s.substring(j + i, i + 2 * j))) {
                    String substring = s.substring(i, i + 2 * j);
                    if (substring.length() > longestStr.length()) {
                        longestStr = substring;
                    }
                }
            }
        }
        return longestStr;
    }
*/

    public static void main(String[] args) {
        String abab = longestDupSubstring("ababc");
        System.out.println(abab);
    }

}
