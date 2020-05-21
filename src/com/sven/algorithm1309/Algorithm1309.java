package com.sven.algorithm1309;

public class Algorithm1309 {
}

class Solution {

    public String freqAlphabets(String s) {
        int idx = 0, n = s.length();
        StringBuilder builder = new StringBuilder();
        while (idx < n) {
            if (idx + 2 < n && s.charAt(idx + 2) == '#') {
                builder.append((char) ('a' + (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0')));
                idx += 2;
            } else {
                builder.append((char) ('a' + s.charAt(idx) - '0'));
            }
            idx++;
        }
        return builder.toString();
    }
}