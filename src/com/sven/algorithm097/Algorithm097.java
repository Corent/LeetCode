package com.sven.algorithm097;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/23
 */
public class Algorithm097 {
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1 == null && s2 == null) return s3 == null;
        if (s1 == null && s2 != null) return s2.equals(s3);
        if (s1 != null && s2 == null) return s1.equals(s3);
        int len1 = s1.length(), len2 = s2.length();
        if (s3 == null || len1 + len2 != s3.length()) return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];   //dp[i][j]表示s1前i个字符，s2前j个字符，能否与s3前i + j个字符匹配
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i != 0 && j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                            dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j  -1);
                }
            }
        }
        return dp[len1][len2];
    }
}