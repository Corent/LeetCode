package com.sven.algorithm238;

public class Algorithm238 {
}

/**
 * 剑指Offer 面试题52
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n], ans = new int[n];

        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            left[i] = left[i - 1] * nums[i - 1];
            right[j] = right[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < n; i++) ans[i] = left[i] * right[i];
        return ans;
    }
}

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++)
            ans[i] = nums[i - 1] * ans[i - 1];
        int r = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;
    }
}