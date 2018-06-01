package com.sven.algorithm188;

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