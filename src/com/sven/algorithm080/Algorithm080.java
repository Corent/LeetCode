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

/**
 * Algorithm026: Remove Duplicates from Sorted Array
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (cnt < 2
                    || nums[cnt - 2] != nums[i] && nums[cnt - 1] == nums[i] // 当前数的第二个，新的数与当前数相等
                    || nums[cnt - 1] != nums[i]) {  // 当前数只出现一次，新的数与当前数不相等
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}