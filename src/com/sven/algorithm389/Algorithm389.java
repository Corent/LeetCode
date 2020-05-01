package com.sven.algorithm389;

public class Algorithm389 {
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] chs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chs[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            chs[ch - 'a']--;
            if (chs[ch - 'a'] < 0) return ch;
        }
        return 0;
    }
}