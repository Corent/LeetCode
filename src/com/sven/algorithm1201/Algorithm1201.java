package com.sven.algorithm1201;

public class Algorithm1201 {
}

/**
 * https://www.acwing.com/solution/leetcode/content/4743/
 */
class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1, right = Integer.MAX_VALUE;
        long ab = a / gcd(a, b) * b;
        long ac = a / gcd(a, c) * c;
        long bc = b / gcd(b, c) * c;
        long abc = ab / gcd(ab, c) * c;

        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long cnt = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (cnt >= n) right = mid;
            else left = mid + 1;
        }

        return Long.valueOf(left).intValue();
    }

    private long gcd(long x, long y) {
        if (y > x) return gcd(y, x);
        long tmp = x % y;
        while (tmp != 0) {
            x = y;
            y = tmp;
            tmp = x % y;
        }
        return y;
    }
}