package com.sven.algorithm713;

public class Algorithm713 {
}

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int m = 1, n = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            m *= nums[j];
            while (m >= k) {
                m /= nums[i++];
            }
            n += (j - i + 1);
        }
        return n;
    }
}