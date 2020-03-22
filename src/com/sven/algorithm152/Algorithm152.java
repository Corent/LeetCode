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
        int ans = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTmp = max * nums[i], minTmp = min * nums[i];
            max = Math.max(Math.max(maxTmp, minTmp), nums[i]);
            min = Math.min(Math.min(maxTmp, minTmp), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}