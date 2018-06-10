package com.sven.algorithm213;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm213 {
}

class Solution {

    private int[] nums;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        this.nums = nums;
        return Math.max(rob(0, nums.length - 2), rob(1, nums.length - 1));
    }

    private int rob(int from, int to) {
        int n = to - from + 1;
        if (n == 0) return 0;
        if (n == 1) return nums[from];
        if (n == 2) return Math.max(nums[from], nums[to]);

        int[] dp = new int[n];  //dp[i]表示抢劫第i个房子获取的最大利益
        dp[0] = nums[from];
        dp[1] = nums[from + 1];
        dp[2] = nums[from] + nums[from + 2];
        for (int i = 3; i < n; i++) {
            dp[i] = nums[from + i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[n - 2], dp[n - 1]);
    }
}