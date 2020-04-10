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

/**
 * 剑指Offer 面试题8
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        if (n == 1) return nums[0];
        int i = 0, j = n - 1, mid = i;
        while (nums[i] >= nums[j]) {

            if (j - i == 1) {
                mid = j;
                break;
            }

            mid = (i + j) / 2;
            if (nums[mid] > nums[j]) i = mid;
            else if (nums[mid] < nums[j]) j = mid;
            else j--;
        }
        return nums[mid];
    }
}