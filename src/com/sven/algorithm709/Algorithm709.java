package com.sven.algorithm709;

public class Algorithm709 {
}

class Solution {

    private static int DIFF = 'a' - 'A';

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chs = new char[str.length()];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = str.charAt(i);
            if (chs[i] >= 'A' && chs[i] <= 'Z') {
                chs[i] += DIFF;
            }
        }
        return new String(chs);
    }
}