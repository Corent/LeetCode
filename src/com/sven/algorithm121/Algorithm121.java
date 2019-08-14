package com.sven.algorithm121;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/30
 */
public class Algorithm121 {
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        if (prices == null || prices.length == 0) return ans;
        // low[i]数组表示在第i天前的最小值，high[i]表示第i天之后的最大值
        // 算出这两个数组后max(high[i] - low[i])即为所求
        int[] low = new int[prices.length], high = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            low[i] = i == 0? prices[i]: Math.min(low[i - 1], prices[i]);
        }
        for (int i = prices.length - 1; i >= 0; i--) {
            high[i] = (i == prices.length - 1)? prices[i]: Math.max(high[i + 1], prices[i]);
            ans = Math.max(ans, high[i] - low[i]);
        }
        return ans;
    }
}