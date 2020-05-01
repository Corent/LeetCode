package com.sven.algorithm375;

public class Algorithm375 {
}

/**
 * dp[j][i]代表j到i所需花的最少的钱数
 * https://blog.csdn.net/qq_38595487/article/details/83590491
 */
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                int temp = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; k++) {
                    temp = Math.min(temp, k + Math.max(dp[j][k - 1], dp[k + 1][i]) );
                }
                dp[j][i] = j + 1 == i ? j : temp;
            }
        }
        return dp[1][n];
    }
}