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