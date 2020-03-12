package com.sven.algorithm123;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/30
 */
public class Algorithm123 {
}

/**
 * https://segmentfault.com/a/1190000002565570
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;

        int[] preProfit = new int[n];   //preProfit[i]表示从第0天到第i天的最大收益
        preProfit[0] = 0;
        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }

        int[] postProfit = new int[n];  //postProfit[i]表示从第i天到第n - 1天的最大收益
        postProfit[n - 1] = 0;
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, preProfit[i] + postProfit[i]);
        }

        return ans;
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] dp1 = new int[prices.length], dp2 = new int[prices.length];
        int preMin = prices[0], postMax = prices[prices.length - 1], ans = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            preMin = Math.min(preMin, prices[i]);
            dp1[i] = Math.max(dp1[i - 1], prices[i] - preMin);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            postMax = Math.max(postMax, prices[i]);
            dp2[i] = Math.max(dp2[i + 1], postMax - prices[i]);
            ans = Math.max(ans, dp1[i] + dp2[i]);
        }
        return ans;
    }
}