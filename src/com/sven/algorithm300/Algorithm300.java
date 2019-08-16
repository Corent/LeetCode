package com.sven.algorithm300;

import java.util.ArrayList;
import java.util.List;

public class Algorithm300 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 4}));
    }
}

/**
 * O(N^2)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int m = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    m = Math.max(m, dp[j]);
                }
            }
            dp[i] = m + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

/**
 * O(nlog(n))
 * https://leetcode.com/problems/longest-increasing-subsequence/discuss/152065/Python-explain-the-O(nlogn)-solution-step-by-step
 */
class Solution2 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int lastIdx = list.size() - 1;
            if (lastIdx < 0 || nums[i] > list.get(lastIdx)) list.add(nums[i]);
            else if (nums[i] < list.get(0)) list.set(0, nums[i]);
            else list.set(binarySearch(list, nums[i]), nums[i]);
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int value) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < value) left = mid + 1;
            else if (list.get(mid) > value) right = mid - 1;
            else return mid;
        }
        return left;
    }
}