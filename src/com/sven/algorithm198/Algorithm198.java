package com.sven.algorithm198;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm198 {
}

/**
 * https://blog.csdn.net/derrantcm/article/details/47970775
 */

class Solution {
    public int rob(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int[] yes = new int[nums.length], no = new int[nums.length];
        yes[0] = nums[0];
        no[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            yes[i] = no[i - 1] + nums[i];
            no[i] = Math.max(yes[i - 1], no[i - 1]);
        }
        return Math.max(yes[nums.length - 1], no[nums.length - 1]);
    }
}