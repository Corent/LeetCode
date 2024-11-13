package com.sven.algorithm357;

public class Algorithm357 {
}

/**
 * 排列组合 + dp
 * https://blog.csdn.net/leoma2012/article/details/86763256
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 2) return Double.valueOf(Math.pow(10, n)).intValue();
        int ans = 10, tmp = 9; // n > 1 时，最高位9种选择，即1-9
        for (int i = 2; i < n + 1; i++) {
            tmp *= 9 - (i - 2);
            ans += tmp;
        }
        return ans;
    }
}