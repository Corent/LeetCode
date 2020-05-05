package com.sven.algorithm461;

public class Algorithm461 {
}

class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y, cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }
}