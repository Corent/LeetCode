package com.sven.algorithm414;

public class Algorithm414 {
}

class Solution {
    public int thirdMax(int[] nums) {
        long first = Integer.MIN_VALUE - 1L;
        long second = Integer.MIN_VALUE - 1L;
        long third = Integer.MIN_VALUE - 1L;
        for (int n: nums) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }

        return Long.valueOf(third != Integer.MIN_VALUE - 1L ? third : first).intValue();
    }
}