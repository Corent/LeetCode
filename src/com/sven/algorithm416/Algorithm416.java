package com.sven.algorithm416;

import java.util.Arrays;

public class Algorithm416 {
}

/**
 * dp[i]代表是否存在能够组成 sum = i 的子数组
 * https://blog.csdn.net/abc15766228491/article/details/83116703
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0) return false;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n: nums) {
            for (int i = sum >> 1; i >= 0; i--) {
                if (dp[i]) dp[i + n] = true;
            }
            if (dp[sum >> 1]) return true;
        }
        return false;
    }
}
class Solution2 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) != 0) return false;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n: nums) {
            for (int i = sum >> 1; i >= n; i--) {
                dp[i] = dp[i] || dp[i - n];
            }
            if (dp[sum >> 1]) return true;
        }
        return false;
    }
}