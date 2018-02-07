package com.sven.algorithm058;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 06/02/2018
 */
public class Algorithm058 {
}

/**
 * 从后往前遍历找到第一个不为空格的字符，
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) return ans;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') continue;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            return i - j;
        }
        return ans;
    }
}