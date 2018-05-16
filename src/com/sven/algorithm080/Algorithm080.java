package com.sven.algorithm080;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/16
 */
public class Algorithm080 {
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (cnt < 2 || nums[cnt - 2] != nums[i] && nums[cnt - 1] == nums[i] || nums[cnt - 1] != nums[i]) {
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}