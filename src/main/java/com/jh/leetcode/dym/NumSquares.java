package com.jh.leetcode.dym;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class NumSquares {
    public static void main(String[] args) {
        int i = numSquares(2);
        System.out.println(i);
    }

    //定义状态 dp[i]  d[n]为总数为n时的最少数量
    //定义状态为 d(n)=min(d(n-a[i]）+1,d(n-a[i-1])+1，……,d(n-a[0])+1))
    public static int numSquares(int n) {
        //  从平方根取值开始计算
        int half = (int) Math.sqrt(n);
        //  构造备选结果
        int[] nums =new int[half];
        for (int i = 1; i <= nums.length; i++) {
            nums[i]=i*i;
        }
        return 0;
    }

}
