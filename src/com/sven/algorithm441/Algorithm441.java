package com.sven.algorithm441;

public class Algorithm441 {
}

class Solution {

    public int arrangeCoins(int n) {
        long m = 1;
        while (m * (m + 1) / 2 < n) m++;
        return Long.valueOf(m * (m + 1) / 2 == n ? m : m - 1).intValue();
    }
}

class Solution2 {

    public int arrangeCoins(int n) {
        return Double.valueOf((Math.sqrt(8 * Double.valueOf(n) + 1) - 1) / 2).intValue();
    }
}