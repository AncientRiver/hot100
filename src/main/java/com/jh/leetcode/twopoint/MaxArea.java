package com.jh.leetcode.twopoint;

class MaxArea {
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i != j) {
            int area = (j - i ) * Math.min(height[i], height[j]);
            max=Math.max(area,max);
            int maxHeightIndex = height[i] < height[j] ? j : i;
            if (maxHeightIndex==j){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] p=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(p));
    }
}