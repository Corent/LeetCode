package com.sven.algorithm459;

public class Algorithm459 {

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("aba"));
    }
}

class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2) return false;
        int i = 1;
        for (; i < n; i++) {
            if (n % i != 0) continue;
            String pattern = s.substring(0, i);
            int j = i;
            while (j + i <= n) {
                String next = s.substring(j, j + i);
                if (!next.equals(pattern)) break;
                j += i;
            }
            if (j == n) return true;
        }
        return false;
    }
}