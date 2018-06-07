package com.sven.algorithm152;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm152 {
}

class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int ans = nums[0], a = nums[0], b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTmp = a * nums[i], minTmp = b * nums[i];
            a = Math.max(Math.max(maxTmp, minTmp), nums[i]);
            b = Math.min(Math.min(maxTmp, minTmp), nums[i]);
            ans = Math.max(ans, a);
        }
        return ans;
    }
}