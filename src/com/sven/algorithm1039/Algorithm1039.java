package com.sven.algorithm1039;

public class Algorithm1039 {
}

class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i < n; ++i) {
                int j = i + len - 1;
                int tmp = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    tmp = Math.min(tmp, A[i] * A[j % n] * A[k % n] + dp[i][k % n] + dp[k % n][j % n]);
                }
                dp[i][j % n] = tmp;
            }
        }
        return dp[0][n - 1];
    }
}