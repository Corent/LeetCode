package com.sven.algorithm060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 07/02/2018
 */
public class Algorithm060 {

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 1));
    }
}

/**
 * 参考Algorithm031
 */
class Solution {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        for (int i = 1; i < k; i++) nextPermutation(nums);
        StringBuilder builder = new StringBuilder();
        for (int num: nums) builder.append(num);
        return builder.toString();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) idx--;
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int target = idx + 1;
        while (target < nums.length && nums[target] > nums[idx]) target++;
        swap(nums, idx, target - 1);
        reverse(nums, idx + 1, nums.length - 1);
    }
}