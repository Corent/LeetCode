package com.sven.algorithm397;

public class Algorithm397 {
}

class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 1;
        if (n == 1) return 0;
        int cnt = 0;
        while ((n & 1) == 0) {
            cnt++;
            n >>= 1;
        }
        if (n == 1) return cnt;
        return cnt + 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
    }
}