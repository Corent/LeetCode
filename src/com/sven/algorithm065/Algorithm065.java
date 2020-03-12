package com.sven.algorithm065;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 10/02/2018
 */
public class Algorithm065 {

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("3"));
    }
}

class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        int i = 0, n = s.length();
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean ans = false, dot = false, exp = false;
        while (i < n) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') ans = true;
            else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (!ans || exp) return false;
                exp = true;
                ans = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return false;
            } else return false;
            i++;
        }
        return ans;
    }
}