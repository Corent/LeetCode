package com.sven.algorithm848;

public class Algorithm848 {
}

class Solution {

    public String shiftingLetters(String S, int[] shifts) {
        Integer n = null;
        char[] chs = new char[shifts.length];
        for (int i = shifts.length - 1; i >= 0; i--) {
            n = n == null ? shifts[i] % 26 : (n + shifts[i]) % 26;
            chs[i] = (char) (((n + (S.charAt(i) - 'a')) % 26) + 'a');
        }
        return new String(chs);
    }
}