package com.sven.algorithm693;

public class Algorithm693 {
}

class Solution {

    public boolean hasAlternatingBits(int n) {
        int bit = n & 1;
        n >>= 1;
        while (n != 0) {
            if ((n & 1) != (1 - bit)) return false;
            bit = 1 - bit;
            n >>= 1;
        }
        return true;
    }
}