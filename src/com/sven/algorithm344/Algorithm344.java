package com.sven.algorithm344;

public class Algorithm344 {
}

class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) return;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] == s[j]) continue;
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}