package com.sven.algorithm154;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm154 {
}

class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (Integer n: nums) ans = Math.min(ans, n);
        return ans;
    }
}