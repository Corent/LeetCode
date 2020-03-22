package com.sven.algorithm081;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/17
 */
public class Algorithm081 {
}

/**
 * https://blog.csdn.net/TempterCyn/article/details/84728538
 * https://www.cnblogs.com/ariel-dreamland/p/9159124.html
 *
 * LeetCode 154
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else right--;
        }

        return false;
    }
}