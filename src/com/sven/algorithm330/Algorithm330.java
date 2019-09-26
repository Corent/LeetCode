package com.sven.algorithm330;

public class Algorithm330 {
}

/**
 * 贪心算法
 * https://blog.csdn.net/magicbean2/article/details/76583378
 */
class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0, ans = 0;
        long bound = 1, m = nums.length;
        while (bound <= n) {
            if (i < m && nums[i] <= bound) bound += nums[i++];
            else {
                bound <<= 1;
                ans++;
            }
        }
        return ans;
    }
}