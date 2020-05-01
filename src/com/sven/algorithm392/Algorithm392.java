package com.sven.algorithm392;

public class Algorithm392 {
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++i == s.length()) return true;
            }
        }
        return false;
    }
}