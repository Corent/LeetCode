package com.sven.algorithm268;

public class Algorithm268 {
}

class Solution {
    public int missingNumber(int[] nums) {
        int n = 0, m = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            n ^= i;
            if (i > 1) {
                m ^= nums[i - 1];
            }
        }
        return n ^ m;
    }
}