package com.sven.algorithm242;

public class Algorithm242 {
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        int ns = s.length(), nt = t.length();
        if (ns != nt) return false;
        int[] chs = new int[256];
        for (int i = 0; i < ns; i++) chs[s.charAt(i)]++;
        for (int i = 0; i < nt; i++) {
            if (chs[t.charAt(i)] == 0) return false;
            chs[t.charAt(i)]--;
        }
        return true;
    }
}