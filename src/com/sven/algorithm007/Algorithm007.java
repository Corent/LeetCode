package com.sven.algorithm007;

public class Algorithm007 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483648));
    }
}

/**
 * 转为String处理，注意溢出
 */
class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        Long tmp = Math.abs(Long.valueOf(x));
        tmp = Long.valueOf(new StringBuilder(String.valueOf(tmp)).reverse().toString());
        if (isNegative && tmp > Math.abs(Integer.MAX_VALUE) || !isNegative && tmp > Integer.MAX_VALUE) return 0;
        return tmp.intValue() * (isNegative? -1: 1);
    }
}