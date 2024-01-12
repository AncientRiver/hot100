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
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
        }

        int i = numSquares(2);
        System.out.println(i);
    }

    public static int numSquares(int n) {
        //  从平方根取值开始计算
        int half = (int) Math.sqrt(n);

        return numSquares(n, half);
    }

    /**
     * 贪心法
     */
    private static int numSquares(int n, int num) {
        int originSum = n;
        int originHaf = num;
        int i = 0;
        while (n != 0) {
            if (num!=1 && n % (num * num) == 0) {
                return i + n % (num * num);
            }
            if (n - num * num >= 0) {
                n -= num * num;
                i++;
            }
            //如果num为0,说明没救了,重启,原来num-1来
            if (--num == 0 && n != 0) {
                n = originSum;
                num = originHaf - 1;
                i = 0;
            }
        }
        return i;
    }
}
