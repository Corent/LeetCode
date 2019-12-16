package com.sven.algorithm345;

import java.util.HashSet;
import java.util.Set;

public class Algorithm345 {
}

class Solution {

    private Set<Character> vowels = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chs = s.toCharArray();
        for (int i = 0, j = chs.length - 1; i < j;) {
            if (vowels.contains(chs[i]) && vowels.contains(chs[j])) {
                char t = chs[i];
                chs[i] = chs[j];
                chs[j] = t;
                i++;
                j--;
            } else if (!vowels.contains(chs[i]) && vowels.contains(chs[j])) {
                i++;
            } else if (vowels.contains(chs[i]) && !vowels.contains(chs[j])) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return new String(chs);
    }
}