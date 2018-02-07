package com.sven.algorithm053;

public class Algorithm053 {
}

/**
 * dp[i]表示以nums[i]结尾的连续子数组的最大和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (i == 0 || dp[i - 1] < 0)? nums[i]: dp[i - 1] + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}