package com.sven.algorithm188;

import java.util.stream.IntStream;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/31
 */
public class Algorithm188 {
}

/**
 * https://segmentfault.com/a/1190000002565570
 */

class Solution {

    public int maxProfit(int k, int[] prices) {

        if (k < 1 || prices == null) return 0;
        int n = prices.length;
        if (k >= n) return maxProfit2(prices);

        int[] local = new int[k + 1], global = new int[k + 1];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j > 0; j--) {
                local[j] = Math.max(global[j - 1], local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }

    public int maxProfit2D(int k, int[] prices) {

        if (k < 1 || prices == null) return 0;
        int n = prices.length;
        if (k >= n) return maxProfit2(prices);

        int[][] local = new int[n][k + 1], global = new int[n][k + 1];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j > 0; j--) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n - 1][k];
    }

    private int maxProfit2(int[] prices) {

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}

/**
 * 差分数组，dp[i][j][0|1](以i结尾，j段) => dp[k][0]表示前面取了k段，但是这一段没取的k段最大和，dp[k][0]表示这一段取了的k段最大和
 * https://www.bilibili.com/video/av70645396?from=search&seid=5452797083633288841
 */
class Solution2 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) return 0;
        int n = prices.length, ans = 0;
        if (k > n / 2) k = n / 2;
        int[] diffs = new int[--n];
        IntStream.rangeClosed(1, n).forEach(i -> diffs[i - 1] = prices[i] - prices[i - 1]);
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1]);
                dp[j][1] = Math.max(dp[j - 1][0], dp[j][1]) + diffs[i];
                ans = Math.max(ans, Math.max(dp[j][0], dp[j][1]));
            }
        }
        return ans;
    }
}

/**
 * dp[i][j][0|1] 第i位第j次交易，0 已买入 1 已卖出，状态转移
 * dp[i][j][1] <- dp[i - 1][j][0] + price[i] (进行了操作) OR dp[i - 1][j][1] (不进行操作)
 * dp[i][j][0] <- dp[i - 1][j - 1][1] (进行了操作) OR dp[i - 1][j][1] (不进行操作)
 * 第一维可以干掉
 *
 * https://www.bilibili.com/video/av70645396?from=search&seid=5452797083633288841
 */
class Solution3 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) return 0;
        int n = prices.length, ans = 0;
        if (k > n / 2) k = n / 2;
        int[][] dp = new int[k + 1][2];
        for (int j = k; j >= 0; j--) {
            dp[j][0] = Integer.MIN_VALUE;
            dp[j][1] = Integer.MIN_VALUE;
        }
        dp[0][1] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if (dp[j][0] != Integer.MIN_VALUE) dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                if (dp[j - 1][1] != Integer.MIN_VALUE) dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                if (i == n - 1) ans = Math.max(ans, dp[j][1]);
            }
        }
        return ans;
    }
}