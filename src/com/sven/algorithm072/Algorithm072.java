package com.sven.algorithm072;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 27/04/2018
 */
public class Algorithm072 {
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1)? dp[i - 1][j - 1]: Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][i], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }
}