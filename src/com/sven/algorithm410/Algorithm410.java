package com.sven.algorithm410;

public class Algorithm410 {

    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[] {1, 2147483647}, 2));
    }
}

/**
 * dp
 * dp[i][j]表示把nums[0 - j]分成i组，各组和中最大值的最小值
 * dp[1][j] = sum(0, j)
 * dp[i][j] = min(max(dp[i - 1][k], sum(k + 1, j))) 0 <= k < j
 * https://www.bilibili.com/video/BV14W411d7D4?from=search&seid=13755479025981742037
 */
class Solution {

    private long[] sums;

    public int splitArray(int[] nums, int m) {
        sums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = i == 0 ? nums[0] : sums[i - 1] + nums[i];
        }
        if (m == 1) return Long.valueOf(sums[sums.length - 1]).intValue();
        long[][] dp = new long[m + 1][nums.length];
        for (int i = 1; i <= m; i++) {
            for (int j = i - 1; j < nums.length; j++) {
                if (i == 1) dp[i][j] = sum(0, j);
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], sum(k + 1, j)));
                    }
                }
            }
        }

        return Long.valueOf(dp[m][nums.length - 1]).intValue();
    }

    private long sum(int i, int j) {
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }
}

/**
 * 二分法
 * https://blog.csdn.net/zhangjingao/article/details/86607677
 */
class Solution2 {

    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0, result = 0;
        for (int n : nums) right += n;
        while (left <= right) {
            long mid = left + right >> 1;
            if (judge(mid, nums, m)) {
                result = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return Long.valueOf(result).intValue();
    }

    /**
     * 判断是否可以划分为m组，每组和都小于mid
     * @param mid
     * @param nums
     * @param m
     * @return
     */
    private boolean judge(long mid, int[] nums, int m) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) return false;
            if (sum + nums[i] > mid) {
                sum = nums[i];
                m--;
            } else sum += nums[i];
        }
        return m >= 1;
    }
}