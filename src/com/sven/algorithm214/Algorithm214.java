package com.sven.algorithm214;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm214 {
}

/**
 * 寻找最长回文前缀
 * KMP
 * https://www.cnblogs.com/grandyang/p/4523624.html
 * https://blog.csdn.net/yujin753/article/details/47047155
 */
class Solution {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        int[] next = new int[t.length()];   //next[i]表示从t[i]到开头的子串的相同前缀后缀的个数
        for (int i = 1; i < t.length(); ++i) {
            int j = next[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) j = next[j - 1];
            j += (t.charAt(i) == t.charAt(j)) ? 1 : 0;
            next[i] = j;
        }
        return r.substring(0, s.length() - next[t.length() - 1]) + s;
    }
}

class Solution2 {
    public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char[] chs = s.toCharArray();
        while (i < j) {
            if (chs[i] == chs[j]) {
                ++i;
                --j;
            } else {
                i = 0;
                j = --end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}