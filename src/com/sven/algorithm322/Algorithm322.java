package com.sven.algorithm322;

import java.util.Arrays;

public class Algorithm322 {

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[] {2}, 3));
    }
}

/**
 * 经典dp
 * dp[j]表示组成价值为j的最小硬币数
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                int idx = i - coin;
                if (idx >= 0 && dp[idx] != -1) {
                    dp[i] = dp[i] == -1? dp[idx] + 1: Math.min(dp[i], dp[idx] + 1);
                }
            }
        }
        return dp[amount];
    }
}