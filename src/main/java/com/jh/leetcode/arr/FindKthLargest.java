package com.jh.leetcode.arr;

import java.util.Arrays;
import java.util.Comparator;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).skip(k).findFirst().orElse(0);
    }
}
