package com.sven.algorithm371;

public class Algorithm371 {
}

/**
 * 剑指Offer 面试题47
 * https://blog.csdn.net/cherrydreamsover/article/details/81037972
 */
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}