package com.sven.algorithm312;

import java.util.ArrayList;
import java.util.List;

public class Algorithm312 {

    public static void main(String[] args) {
        System.out.println(new Solution2().maxCoins(new int[] {3, 1, 5, 8}));
    }
}

/**
 * 递归回溯，用屁股想想都知道会超时
 */
class Solution {

    private int ans = Integer.MIN_VALUE;

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n: nums) list.add(n);
        maCoins(list, 0);
        return ans;
    }

    private void maCoins(List<Integer> nums, int value) {
        int n = nums.size();
        if (n == 1) {
            ans = Math.max(ans, value + nums.get(0));
            return;
        }

        for (int i = 0; i < n; i++) {
            int m = nums.get(i);
            int left = i == 0? 1: nums.get(i - 1);
            int right = i == (n - 1)? 1: nums.get(i + 1);
            List<Integer> nextNums = new ArrayList<>(n - 1);
            for (int j = 0; j < n; j++) if (j != i) nextNums.add(nums.get(j));
            maCoins(nextNums, value + left * m * right);
        }
    }
}

/**
 * dp
 * https://blog.csdn.net/cjl707408282/article/details/77919485
 */
class Solution2 {

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] arr = new int[n];
        for (int i = 1; i < n - 1; i++) arr[i] = nums[i - 1];
        arr[0] = arr[n - 1] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) { // K是left和right的距离
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
                }
            }
        }

        return dp[0][n - 1];
    }
}