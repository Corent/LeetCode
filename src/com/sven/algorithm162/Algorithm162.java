package com.sven.algorithm162;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm162 {
}

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (l == r) return l;
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;   // 题目限定没有nums[mid] == nums[mid + 1]的情况
        }
        return -1;
    }
}