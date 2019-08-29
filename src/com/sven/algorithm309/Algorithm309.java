package com.sven.algorithm309;

public class Algorithm309 {
}

/**
 * https://blog.csdn.net/zjuPeco/article/details/76468185
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int s0 = 0, s1 = -prices[0], s2 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++){
            int pre0 = s0;
            int pre1 = s1;
            int pre2 = s2;
            s0 = Math.max(pre0, pre2);
            s1 = Math.max(pre0 - prices[i], pre1);
            s2 = pre1 + prices[i];
        }
        return Math.max(s0, s2);
    }
}