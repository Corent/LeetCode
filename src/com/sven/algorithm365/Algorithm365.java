package com.sven.algorithm365;

public class Algorithm365 {
}

/**
 * 判断z是否能被x和y的最大公约数整除
 */
class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (z == 0 || z == x || z == y || z == x + y) return true;
        if (x == 0 || y == 0) return z == Math.max(x, y);
        return z % gcd(x, y) == 0;
    }

    /**
     * 最大公约数的求法
     *
     * 辗转相除法：大数a/小数b，求余数temp，若temp=0，则b为最大公约数，否则，令a=b, b=temp;
     * 更相减损法：a > b，它们的最大公约数等于a-b的差值c和较小数b的最大公约数。依次递归下去，直到两个数相等。这相等两个数的值就是所求最大公约数。
     */
    private int gcd(int x, int y) {
        if (y > x) return gcd(y, x);
        int tmp = x % y;
        while (tmp != 0) {
            x = y;
            y = tmp;
            tmp = x % y;
        }
        return y;
    }
}