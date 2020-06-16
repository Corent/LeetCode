package com.sven.algorithm1017;

public class Algorithm1017 {
}

/**
 * https://blog.csdn.net/qq_17550379/article/details/88942131
 */
class Solution {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder builder = new StringBuilder();
        while (N != 0) {
            int n = N % -2;
            N /= -2;
            if (n < 0) {
                N++;
                n += 2;
            }
            builder.append(n);
        }
        return builder.reverse().toString();
    }
}