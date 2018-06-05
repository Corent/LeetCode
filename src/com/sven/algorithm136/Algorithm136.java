package com.sven.algorithm136;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/4
 */
public class Algorithm136 {
}

class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) ans ^= nums[i];
        return ans;
    }
}