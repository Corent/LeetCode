package com.sven.algorithm1007;

public class Algorithm1007 {
}

/**
 * https://blog.csdn.net/Cold_Sun_/article/details/100688013
 */
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] num = new int[6], numA = new int[6], numB = new int[6];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                num[A[i] - 1]++;
                continue;
            }
            num[A[i] - 1]++;
            num[B[i] - 1]++;
            numB[A[i] - 1]++;
            numA[B[i] - 1]++;
        }

        for (int i = 0; i < 6; i++) {
            if (num[i] == A.length) {
                return Math.min(numA[i], numB[i]);
            }
        }
        return -1;
    }
}