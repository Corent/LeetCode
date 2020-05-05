package com.sven.algorithm479;

public class Algorithm479 {
}

/**
 * https://leetcode.com/problems/largest-palindrome-product/submissions/
 */
class Solution {

    public int largestPalindrome(int n) {
        int upper = Double.valueOf(Math.pow(10, n)).intValue() - 1, lower = upper / 10;
        for (int i = upper; i > lower; --i) {
            String t = String.valueOf(i);
            long p = Long.valueOf(t + new StringBuilder(t).reverse().toString());
            for (long j = upper; j * j > p; --j) {
                if (p % j == 0)
                    return Long.valueOf(p % 1337).intValue();
            }
        }
        return 9;
    }
}