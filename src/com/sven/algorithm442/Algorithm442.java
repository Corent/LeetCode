package com.sven.algorithm442;

import java.util.ArrayList;
import java.util.List;

public class Algorithm442 {
}

/**
 * https://blog.csdn.net/u013942370/article/details/82829118
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length < 2) return ans;
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1, n = nums[idx];
            if (n < 0) ans.add(Math.abs(nums[i]));
            else nums[idx] = -n;
        }
        return ans;
    }
}