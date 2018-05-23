package com.sven.algorithm096;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm096 {
}

class Solution {
    public int numTrees(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = 0, b = i - 1;
            while (a <= b) {
                dp[i] += dp[a] * dp[b] * (a == b? 1: 2);
                a++;
                b--;
            }
        }
        return dp[n];
    }
}