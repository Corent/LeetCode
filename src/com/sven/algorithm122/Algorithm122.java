package com.sven.algorithm122;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/30
 */
public class Algorithm122 {
}

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        if (prices == null || prices.length < 2) return ans;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }
}