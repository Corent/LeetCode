package com.sven.algorithm448;

import java.util.ArrayList;
import java.util.List;

public class Algorithm448 {
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length < 2) return ans;
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}