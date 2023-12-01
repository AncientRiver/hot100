package com.jh.leetcode.twopoint;

import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1, 0, 0};
        moveZeroes(target);
        System.out.println(Arrays.toString(target));
    }
}
