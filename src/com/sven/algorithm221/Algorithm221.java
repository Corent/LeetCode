package com.sven.algorithm221;

public class Algorithm221 {
}

/**
 * https://www.cnblogs.com/grandyang/p/4550604.html
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if (matrix == null) return ans;
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        if (n == 0) return ans;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1') dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }
}

class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int ans = 0, pre = 0;
        if (matrix == null) return ans;
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        if (n == 0) return ans;

        int[] dp = new int[m + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                int t = dp[i];
                if (matrix[i - 1][j] == '1') {
                    dp[i] = Math.min(dp[i], Math.min(dp[i - 1], pre)) + 1;
                    ans = Math.max(ans, dp[i]);
                } else dp[i] = 0;
                pre = t;
            }
        }

        return ans * ans;
    }
}