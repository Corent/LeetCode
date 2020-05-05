package com.sven.algorithm474;

public class Algorithm474 {
}

/**
 * 01背包问题变种
 * https://blog.csdn.net/h_666666/article/details/88679577
 */
class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int count0 = 0, count1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') count1++;
                else count0++;
            }
            if (count0 > m || count1 > n) continue;

            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);  // 如果拿count0 和 count1去组成当前字符串时的情况
                }
            }
        }

        return dp[m][n];
    }
}