package com.sven.algorithm260;

public class Algorithm260 {
}

/**
 * 剑指Offer 面试题40
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = 0, num1 = 0, num2 = 0;
        for (int n: nums) {
            tmp ^= n;
        }
        tmp ^= (tmp & (tmp - 1));
        for (int n: nums) {
            if ((n & tmp) != 0) num1 ^= n;
            else num2 ^= n;
        }
        return new int[] {num1, num2};
    }
}