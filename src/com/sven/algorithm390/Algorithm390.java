package com.sven.algorithm390;

public class Algorithm390 {
}

/**
 * 约瑟夫环问题变种
 * f[n] = 2 * (1 + n/2 - f[n/2])
 * https://blog.csdn.net/da_kao_la/article/details/102604865
 */
class Solution {
    public int lastRemaining(int n) {
        return n <= 1 ? n : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}