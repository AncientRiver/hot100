package com.jh.leetcode.dym;

/**
 * 跳台阶的方法数
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int[] arr = new int[n];

        return climbStairs(n, arr);

    }

    public int climbStairs(int n, int[] arr) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n < arr.length && arr[n] != 0) return arr[n];
        int i1= climbStairs(n - 2, arr);
        if (n-2>=0)arr[n-2]=i1;
        int i2 = climbStairs(n - 1, arr);
        if (n-1>=0)arr[n-1]=i1;
        return i1 + i2;
    }
}
