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

/**
 * dp[i]表示以第i个字符结尾的字串有多少种解码方式
 * Algorithm639 Decode Ways II
 */
class Solution {
    
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        else if (n == 1) return s.charAt(0) != '0'? 1: 0;

        int[] dp = new int[n];
        char[] chs = s.toCharArray();
        dp[0] = chs[0] != '0'? 1: 0;
        dp[1] = (chs[0] != '0' && chs[1] != '0' ? 1 : 0) + ((chs[0] != '0' && (toInt(chs[0]) * 10 + toInt(chs[1])) <= 26) ? 1 : 0);

        for (int i = 2; i < n; i++) {
            dp[i] = 0;
            if (chs[i] != '0') dp[i] += dp[i - 1];
            if (chs[i - 1] != '0' && (toInt(chs[i - 1]) * 10 + toInt(chs[i])) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n - 1];
    }

    private int toInt(char c) {
        return c - '0';
    }
}