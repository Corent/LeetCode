package com.sven.algorithm888;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algorithm888 {
}

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        boolean isSwaped = false;
        if (A.length > B.length) {
            isSwaped = true;
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int sumA = Arrays.stream(A).sum(), sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int b: B) {
            sumB += b;
            set.add(b);
        }
        if (sumA == sumB) return new int[] { 0, 0 };
        int diff = (sumB - sumA) >> 1;
        for (int a: A) {
            if (set.contains(a + diff)) {
                return isSwaped ? new int[] { a + diff, a }: new int[] { a, a + diff };
            }
        }
        return new int[] { 0, 0 };
    }
}