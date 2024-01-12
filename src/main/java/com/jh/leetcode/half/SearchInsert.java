package com.jh.leetcode.half;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int search = search(nums, target, start, end);
        return search;
    }
    public int search(int[] nums,int target,int start,int end){
        if (start>end){
            return start;
        }
        int middle=(start+end)/2;
        if (target==nums[middle]){
            return middle;
        }else if (target<nums[middle]){
            return search(nums,target,start,middle-1);
        }else if (target>nums[middle]){
            return search(nums,target,middle+1,end);
        }
        return 0;
    }
}
