package com.sven.algorithm1035;

public class Algorithm1035 {
}

/**
 * 最长公共子序列
 * https://blog.csdn.net/qq_25481047/article/details/93923661
 */
class Solution {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];   // dp[i][j]表示A中前i个元素和B中前j个元素的最长公共子序列
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[A.length][B.length];
    }
}