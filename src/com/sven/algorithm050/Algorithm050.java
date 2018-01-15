package com.sven.algorithm050;

public class Algorithm050 {
}

class Solution {
    public double myPow(double x, int n) {
        if (equal(x, 0.0) && n < 0) return 0.0;
        long absn = Math.abs((long) n);
        double result = myPowWithUnsignedExponent(x, absn);
        return n < 0 ? 1.0 / result : result;
    }

    double myPowWithUnsignedExponent(double base, long exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = myPowWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) result *= base;
        return result;
    }

    private boolean equal(double num1, double num2) {
        return Math.abs(num1 - num2) < 0.0000001;
    }
}