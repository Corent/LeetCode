package com.sven.algorithm368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Algorithm368 {

    public static void main(String[] args) {
        List<Integer> ans = new Solution().largestDivisibleSubset(new int[] { 1, 2, 3 });
        ans.forEach(System.out::println);
    }
}

//  最长递增子序列变种
class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        if (nums == null || nums.length == 0) return new ArrayList<>();
        int idx = -1, maxLen = 0;
        int[] dp = new int[nums.length];
        int[] previous = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(previous, -1);
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            if (i > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            previous[i] = j;
                        }
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                idx = i;
            }
        }

        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = idx; i >= 0; i = previous[i]) {
            ans.addFirst(nums[i]);
        }

        return ans;
    }
}