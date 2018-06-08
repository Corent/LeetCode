package com.sven.algorithm169;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm169 {
}

class Solution {

    public int majorityElement(int[] nums) {
        int ans = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                ans = nums[i];
                cnt++;
            } else if (nums[i] == ans) cnt++;
            else cnt--;
        }
        return ans;
    }
}