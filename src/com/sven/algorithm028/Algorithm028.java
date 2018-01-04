package com.sven.algorithm028;

public class Algorithm028 {
}

/**
 * KMP算法太复杂，网上很多教程
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return 0;
        int m = haystack.length(), n = needle.length();
        if (m < n) return -1;
        for (int i = 0; i < m - n + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }
}