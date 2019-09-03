package com.sven.algorithm326;

public class Algorithm326 {
}

class Solution {
    public boolean isPowerOfThree(int n) {
        double m = Math.log10(n) / Math.log10(3);
        return (m - Double.valueOf(m).intValue()) == 0;
    }
}