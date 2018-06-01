package com.sven.algorithm125;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/1
 */
public class Algorithm125 {

    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        int n = s.length();
        if (n < 2) return true;

        char[] chs = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !(chs[left] >= 'a' && chs[left] <= 'z' || chs[left] >= 'A' && chs[left] <= 'Z' || chs[left] >= '0' && chs[left] <= '9')) left++;
            while (left < right && !(chs[right] >= 'a' && chs[right] <= 'z' || chs[right] >= 'A' && chs[right] <= 'Z' || chs[right] >= '0' && chs[right] <= '9')) right--;
            if (chs[left] >= 'A' && chs[left] <= 'Z') chs[left] += 32;
            if (chs[right] >= 'A' && chs[right] <= 'Z') chs[right] += 32;
            if (chs[left] != chs[right]) return false;
            left++;
            right--;
        }

        return true;
    }
}