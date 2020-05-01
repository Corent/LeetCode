package com.sven.algorithm400;

public class Algorithm400 {
}

/**
 * https://blog.csdn.net/qq_25481047/article/details/88631173
 */
class Solution {
    public int findNthDigit(int n) {
        long len = 1, cnt = 9, start = 1, num;
        while (n > len * cnt) {
            n -= len++ * cnt;
            cnt *= 10;
            start *= 10;
        }
        num = start + (n - 1) / len;
        return String.valueOf(num).charAt(Long.valueOf((n - 1) % len).intValue()) - '0';
    }
}