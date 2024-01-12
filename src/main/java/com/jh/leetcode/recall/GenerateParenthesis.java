package com.jh.leetcode.recall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 生成括号
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        String str = "";
        int left = n;
        int right = n;
        return generate(left, right, str);
    }

    public List<String> generate(int left, int right, String str) {
        if (left == 0 && right == 0) return Collections.singletonList(str);
        List<String> list=new ArrayList<>();
        if (left > 0) {
            list.addAll(generate(left - 1, right, str + "("));
        }
        if (left < right && right > 0) {
            list.addAll(generate(left, right - 1, str + ")"));
        }
        return list;
    }
}
