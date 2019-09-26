package com.sven.algorithm334;

public class Algorithm334 {

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[] {2, 5, 3, 4, 5}));
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= min) min = num;
            else if (num <= secMin) secMin = num;
            else return true;
        }
        return false;
    }
}