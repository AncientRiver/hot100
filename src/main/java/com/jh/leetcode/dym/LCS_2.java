package com.jh.leetcode.dym;

/**
 *给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
 *TODO 暂未做处理，回头写
 */
public class LCS_2 {
    /*
     * 考虑状态 dp[i][j] 为str1[0:i]和str[0:j]的最长公共子串
     * 若str[i]==str[j] 则dp[i][j]=dp[i-1][j-1]+1
     * 若str[i]!=str[j] 则dp[i][j]=Max(dp[i-1][j],dp[i][j-1])
     * 初始值约束
     */
    public String LCS(String str1, String str2) {
        // write code here
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int row = 0, column = 0, max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    row = i - 1;
                    column = j - 1;
                }
            }
        }
        if (row == 0 && column == 0) return "-1";
        int end = row;
        while (row >= 0 && column >= 0 && chars1[row] == chars2[column]) {
            row--;
            column--;
        }
        ;
        return str1.substring(row + 1, end + 1);
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));
    }
}
