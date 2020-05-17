package com.sven.algorithm1092;

public class Algorithm1092 {

    public static void main(String[] args) {
        System.out.println(new Solution().shortestCommonSupersequence("abac", "cba"));
    }
}

/**
 * https://blog.csdn.net/cmy203/article/details/100594444
 */
class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0) return str2;
        if (str2 == null || str2.length() == 0) return str1;
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
        }
        char[] chs = new char[dp[m][n]];
        int i = m, j = n, k = chs.length - 1;
        while (i > 0 || j > 0) {
            if (i == 0) {
                chs[k--] = str2.charAt(--j);
            } else if (j == 0) {
                chs[k--] = str1.charAt(--i);
            } else {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    chs[k--] = str1.charAt(i - 1);
                    i--;
                    j--;
                } else if (dp[i - 1][j] < dp[i][j - 1]) {
                    chs[k--] = str1.charAt(--i);
                } else {
                    chs[k--] = str2.charAt(--j);
                }
            }
        }
        return new String(chs);
    }
}