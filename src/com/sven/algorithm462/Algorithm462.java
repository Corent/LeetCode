package com.sven.algorithm462;

import java.util.Arrays;

public class Algorithm462 {
}

class Solution {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int target = nums[nums.length / 2], cnt = 0;
        for (int num: nums) {
            if (num == target) continue;
            cnt += Math.abs(num - target);
        }
        return cnt;
    }
}