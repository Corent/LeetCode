package com.sven.algorithm1000;

import java.util.Arrays;

public class Algorithm1000 {

    public static void main(String[] args) {
        System.out.println(new Solution().mergeStones(new int[] { 3, 2, 4, 1 }, 2));
    }
}

/**
 * https://www.cnblogs.com/Dylan-Java-NYC/p/11458528.html
 */
class Solution {

    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }

        int[][] dp = new int[n][n];
        for (int size = 2; size <= n; size++) {
            for (int i = 0; i <= n - size; i++) {
                int j = i + size - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int m = i; m < j; m += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }

                if ((size - 1) % (K - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}