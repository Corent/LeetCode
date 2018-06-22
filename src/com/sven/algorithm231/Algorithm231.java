package com.sven.algorithm231;

public class Algorithm231 {
}

/**
 * 超时
 */
/*class Solution {
    public boolean isPowerOfTwo(int n) {
        int m = 1;
        while (m < n) m <<= 1;
        return m == n;
    }
}*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}