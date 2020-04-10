package com.sven.algorithm313;

import java.util.ArrayList;
import java.util.List;

public class Algorithm313 {

    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
    }
}

/**
 * 剑指Offer 面试题34
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] idx = new int[primes.length];

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[idx[j]] * primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                while (dp[idx[j]] * primes[j] <= dp[i]) idx[j]++;
            }
        }
        return dp[n - 1];
    }
}