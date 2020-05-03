package com.sven.algorithm453;

public class Algorithm453 {
}

class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int sum = 0, min = Integer.MAX_VALUE;
        for (int n: nums) {
            sum += n;
            min = Math.min(min, n);
        }
        return sum - min * nums.length;
    }
}