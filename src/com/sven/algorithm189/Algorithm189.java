package com.sven.algorithm189;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm189 {
}

class Solution {

    public void rotate(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < 2) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int from, int to) {
        while (from < to) {
            nums[from] = nums[from] ^ nums[to];
            nums[to] = nums[from] ^ nums[to];
            nums[from] = nums[from] ^ nums[to];
            from++;
            to--;
        }
    }
}