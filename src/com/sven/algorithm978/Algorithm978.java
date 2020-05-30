package com.sven.algorithm978;

public class Algorithm978 {
}

/**
 * 参考Algorithm 376
 */
class Solution {

    public int maxTurbulenceSize(int[] A) {
        if (A == null) return 0;
        if (A.length < 2) return A.length;
        int[] dpOddBigger = new int[A.length], dpEvenBigger = new int[A.length];
        dpOddBigger[0] = dpEvenBigger[0] = 1;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            dpOddBigger[i] = dpEvenBigger[i] = 1;
            if ((i & 1) == 0) { //  even
                if (A[i] > A[i - 1]) {
                    dpEvenBigger[i] = dpEvenBigger[i - 1] + 1;
                } else if (A[i] < A[i - 1]) {
                    dpOddBigger[i] = dpOddBigger[i - 1] + 1;
                }
            } else {    //  odd
                if (A[i] > A[i - 1]) {
                    dpOddBigger[i] = dpOddBigger[i - 1] + 1;
                } else if (A[i] < A[i - 1]) {
                    dpEvenBigger[i] = dpEvenBigger[i - 1] + 1;
                }
            }
            ans = Math.max(ans, Math.max(dpOddBigger[i], dpEvenBigger[i]));
        }
        return ans;
    }
}

class Solution2 {

    public int maxTurbulenceSize(int[] A) {
        if (A == null) return 0;
        if (A.length < 2) return A.length;
        int ans = 1, dpOddBiggerPre = 1, dpEvenBiggerPre = 1;
        for (int i = 1; i < A.length; i++) {
            int dpOddBigger = 1, dpEvenBigger = 1;
            if ((i & 1) == 0) { //  even
                if (A[i] > A[i - 1]) {
                    dpEvenBigger = dpEvenBiggerPre + 1;
                } else if (A[i] < A[i - 1]) {
                    dpOddBigger = dpOddBiggerPre + 1;
                }
            } else {    //  odd
                if (A[i] > A[i - 1]) {
                    dpOddBigger = dpOddBiggerPre + 1;
                } else if (A[i] < A[i - 1]) {
                    dpEvenBigger = dpEvenBiggerPre + 1;
                }
            }
            dpEvenBiggerPre = dpEvenBigger;
            dpOddBiggerPre = dpOddBigger;
            ans = Math.max(ans, Math.max(dpOddBigger, dpEvenBigger));
        }
        return ans;
    }
}