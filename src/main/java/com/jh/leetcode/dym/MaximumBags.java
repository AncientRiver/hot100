package com.jh.leetcode.dym;

import java.util.Arrays;

/**
 * 贪心法解决问题
 *
 * 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
 *
 * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
 */
public class MaximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] currentRest = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            currentRest[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(currentRest);
        int i;
        for (i = 0; i < currentRest.length; i++) {
            if (additionalRocks > 0 ) {
                //如果额外的石头小于当前剩余数，说明无法填满
                if (additionalRocks < currentRest[i]){
                    return i ;
                }else {
                    additionalRocks-=currentRest[i];
                }
            }else {
                return i;
            }
        }
        return 0;
    }
}
