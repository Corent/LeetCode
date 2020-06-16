package com.sven.algorithm1388;

import java.util.Arrays;

public class Algorithm1388 {
}

/**
 * https://www.acwing.com/solution/leetcode/content/10196/
 */
class Solution {

    public int maxSizeSlices(int[] slices) {
        int[] nums = Arrays.copyOf(slices, slices.length);
        nums[0] = slices[slices.length - 1] = Integer.MIN_VALUE;
        return Math.max(solve(slices), solve(nums));
    }

    private int solve(int[] nums) {
        int[][] dp = new int[nums.length][nums.length / 3 + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MIN_VALUE));
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= nums.length / 3; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j == 1) dp[i][1] = Math.max(dp[i][1], nums[i]);
                if (i >= 2 && j >= 1) dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 1] + nums[i]);
            }
        }

        return dp[nums.length - 1][nums.length / 3];
    }
}