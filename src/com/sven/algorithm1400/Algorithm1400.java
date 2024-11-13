package com.sven.algorithm1400;

import java.util.Arrays;

public class Algorithm1400 {
}

/**
 * https://blog.csdn.net/qq_17550379/article/details/105347381
 */
class Solution {
    public boolean canConstruct(String s, int k) {
        if (s == null || s.length() < k) return false;
        int[] hash = new int[256];
        for (char ch: s.toCharArray()) hash[ch]++;
        int cntOfOdd = 0;
        for (int cnt: hash) cntOfOdd += (cnt & 1);
        return cntOfOdd <= k;
    }
}