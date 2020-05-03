package com.sven.algorithm443;

import java.util.Arrays;

public class Algorithm443 {
}

class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int[] hash = new int[256];
        for (char c: chars) hash[c]++;
        int ans = Arrays.stream(hash).filter(n -> n > 0).map(n -> n == 1 ? 1 : 1 + String.valueOf(n).length()).sum();
        if (ans > chars.length) return chars.length;
        int idx = 0, next = 0;
        char ch = chars[idx];
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != ch) {
                int cnt = i - idx;
                chars[next++] = ch;
                if (cnt > 1) {
                    String num = String.valueOf(cnt);
                    for (int j = 0; j < num.length(); j++) chars[next++] = num.charAt(j);
                }
                if (i < chars.length) {
                    idx = i;
                    ch = chars[idx];
                }
            }
        }
        return ans;
    }
}