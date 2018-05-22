package com.sven.algorithm087;

import java.util.Arrays;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm087 {
}

class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
        if (len1 == 1) return s1.equals(s2);
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        for (int i = 0; i < len1; i++) {
            if (chs1[i] != chs2[i]) return false;
        }
        String s11, s12, s21, s22;
        boolean ans = false;
        for (int i = 1; i < len1 && !ans; i++) {
            s11 = s1.substring(0, i);
            s12 = s1.substring(i);
            s21 = s2.substring(0, i);
            s22 = s2.substring(i);
            ans = isScramble(s11, s21) && isScramble(s12, s22);
            if (!ans) {
                s21 = s2.substring(0, len2 - i);
                s22 = s2.substring(len2 - i);
                ans = isScramble(s11, s22) && isScramble(s12, s21);
            }
        }
        return ans;
    }
}