package com.sven.algorithm091;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm091 {
}

class Solution {
    
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        else if (n == 1) return s.charAt(0) != '0'? 1: 0;

        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0'? 1: 0;
        dp[1] = (s.charAt(0) != '0' && s.charAt(1) != '0' ? 1 : 0) + ((s.charAt(0) != '0' && (toInt(s.charAt(0)) * 10 + toInt(s.charAt(1))) <= 26) ? 1 : 0);

        for (int i = 2; i < n; i++) {
            dp[i] = 0;
            if (s.charAt(i) != '0') dp[i] += dp[i - 1];
            if (s.charAt(i - 1) != '0' && (toInt(s.charAt(i - 1)) * 10 + toInt(s.charAt(i))) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n - 1];
    }

    int toInt(char c) {
        return c - '0';
    }
}