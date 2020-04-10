package com.sven.algorithm153;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm153 {
}

/**
 * 剑指Offer 面试题8
 */
class Solution {
    public int findMin(int[] nums) {
        int down = 0, up = nums.length - 1, mid = 0;
        while (down < up) {
            if (nums[down] < nums[up]) {
                mid = down;
                break;
            }

            if (up - down == 1) {
                mid = up;
                break;
            }

            mid = (down + up) / 2;
            if (nums[mid] >= nums[down]) down = mid;
            else if (nums[mid] <= nums[up]) up = mid;
        }
        return nums[mid];
    }
}