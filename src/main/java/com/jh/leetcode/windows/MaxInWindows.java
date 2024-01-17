package com.jh.leetcode.windows;

import java.util.ArrayList;
import java.util.List;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        // write code here
        if (size == 0 || size > num.length) return new ArrayList<>();
        int start = 0, end = size - 1;
        ArrayList<Integer> list=new ArrayList<>();
        while (end != num.length) {
            int maxNum=0;
            for (int i = start; i <= end; i++) {
                if (num[i]>maxNum){
                    maxNum=num[i];
                }
            }
            list.add(maxNum);
            start++;
            end++;
        }
        return list;
    }
}
