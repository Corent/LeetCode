package com.sven.algorithm075;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 09/05/2018
 */
public class Algorithm075 {
}

class Solution {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int idx0 = -1, idx2 = nums.length, idx = 0;
        while (idx < idx2) {
            switch (nums[idx]) {
                case 0:
                    swap(nums, ++idx0, idx++);
                    break;
                case 1:
                    idx++;
                    break;
                case 2:
                    swap(nums, --idx2, idx);
                    break;
                default: break;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}