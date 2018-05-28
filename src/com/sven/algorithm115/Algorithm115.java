package com.sven.algorithm115;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/28
 */
public class Algorithm115 {
}

class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        int m = s.length(), n = t.length();
        if (m < n) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}