package com.sven.algorithm044;

public class Algorithm044 {
}

/**
 * http://shmilyaw-hotmail-com.iteye.com/blog/2154716
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;   //s、p串匹配的位置
        Integer star = null, rs = null; // '*'的位置，s串匹配'*'之后字符串的位置

        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) { //一般的字符匹配
                i++;
                j++;
                continue;
            }
            if (j < p.length() && p.charAt(j) == '*') { //记录下'*'位置和s串开始匹配的位置
                star = j++;
                rs = i;
                continue;
            }
            if (star != null) { //如果曾经遇到'*'，s串从记录下的rs + 1位置开始匹配p串'*'之后的字符串，每一次匹配失败rs位置都向后移动一位
                j = star + 1;
                i = ++rs;
                continue;
            }
            return false;
        }

        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }
}

/**
 * 超时
class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();

        if (p.charAt(j) != '*') {
            if (i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?')) return false;
            return helper(s, p, i + 1, j + 1);
        }

        while (i < s.length()) {
            if (helper(s, p, i, j + 1)) return true;
            i++;
        }
        return helper(s, p, i, j + 1);
    }
}*/
