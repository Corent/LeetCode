package com.sven.algorithm383;

public class Algorithm383 {
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null) return magazine != null;
        if (ransomNote.isEmpty()) return magazine != null;
        int[] chs = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            chs[magazine.charAt(i)]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--chs[ransomNote.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}