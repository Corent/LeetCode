package com.sven.algorithm342;

public class Algorithm342 {
}

class Solution {
    public boolean isPowerOfFour(int num) {
        Double res = Double.valueOf(Math.log(num) / Math.log(4));
        return Math.abs(res - res.intValue()) == 0;
    }
}