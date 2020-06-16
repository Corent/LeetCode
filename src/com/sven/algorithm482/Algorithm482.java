package com.sven.algorithm482;

public class Algorithm482 {
}

class Solution {

    private static int DIFF = 'A' - 'a';    //  32

    public String licenseKeyFormatting(String S, int K) {
        if (S == null) return S;
        StringBuilder builder = new StringBuilder();
        int idx = S.length() - 1, n = 0;
        while (idx >= 0) {
            char ch = S.charAt(idx--);
            if (ch == '-') continue;
            if (ch >= 'a' && ch <= 'z') ch = (char) (ch + DIFF);
            if (n < K) {
                n++;
                builder.append(ch);
            } else {
                n = 0;
                builder.append('-').append(ch);
            }
        }
        return builder.reverse().toString();
    }
}