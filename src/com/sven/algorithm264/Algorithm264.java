package com.sven.algorithm264;

public class Algorithm264 {

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int idx = 1, idx2 = 0, idx3 = 0, idx5 = 0;
        while (idx < n) {
            uglyNums[idx] = Math.min(Math.min(uglyNums[idx2] * 2, uglyNums[idx3] * 3), uglyNums[idx5] * 5);
            while (uglyNums[idx2] * 2 <= uglyNums[idx]) idx2++;
            while (uglyNums[idx3] * 3 <= uglyNums[idx]) idx3++;
            while (uglyNums[idx5] * 5 <= uglyNums[idx]) idx5++;
            idx++;
        }
        return uglyNums[n - 1];
    }
}