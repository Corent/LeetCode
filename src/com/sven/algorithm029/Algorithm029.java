package com.sven.algorithm029;

public class Algorithm029 {

    public static void main(String[] args) {
        System.out.println(new Solution().divide(28, 3));
    }
}

/**
 * http://blog.csdn.net/yuqieshidi/article/details/48829465
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (divisor == 1) return dividend;
        int ans = 0;
        long dend = Math.abs(Long.valueOf(dividend)), sor = Math.abs(Long.valueOf(divisor));
        while (dend >= sor) {
            long digit = 1, tmp = sor;
            while (dend > (tmp <<= 1)) digit <<= 1;
            ans += digit;
            dend -= (tmp >> 1);
        }
        return isNegative? -ans: ans;
    }
}