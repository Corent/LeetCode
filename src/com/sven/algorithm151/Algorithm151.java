package com.sven.algorithm151;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm151 {
}

/**
 * 剑指Offer 面试题42
 */
class Solution {

    private char[] chs;

    public String reverseWords(String s) {

        if (s == null) return null;
        s = s.trim().replaceAll("\\s+", " ");
        int n = s.length();
        if (n < 2) return s;
        this.chs = s.toCharArray();

        int i = 0;
        while (i < n) {
            while (i < n && chs[i] == ' ') i++;
            if (i == n) break;
            int j = i + 1;
            while (j < n && chs[j] != ' ') j++;
            reverse(i, j - 1);
            i = j;
        }

        reverse(0, n - 1);
        return new String(chs);
    }

    private void reverse(int from, int to) {
        while (from < to) {
            char c = chs[from];
            chs[from++] = chs[to];
            chs[to--] = c;
        }
    }
}