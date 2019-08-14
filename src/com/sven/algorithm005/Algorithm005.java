package com.sven.algorithm005;

public class Algorithm005 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}

/**
 * 方法一
 * 字符串每个字符加上字符间的缝隙均可作为回文串的对称中心，共2n-1个，对每个可能的对称中心向左右方向扫描判断最长回文串
 * 方法二
 * 动态规划，bool[][] isPalindrome[i][j]表示ij之间的子串是否是回文，外层循环从后往前，内层循环从外层循环当前位置往后
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int m = s.length(), maxLen = 0;
        String result = "";
        boolean[][] isPalindrome = new boolean[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                int len = j - i + 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 3 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (len > maxLen) {
                        maxLen = len;
                        result = s.substring(i, j + 1);
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }
        return result;
    }
}

/**
 * 动态规划法，反方向也可以
 */
class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int m = s.length(), maxLen = 0;
        String result = "";
        boolean[][] isPalindrome = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i; j >= 0; j--) {
                int len = i - j + 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 3 || isPalindrome[i - 1][j + 1])) {
                    isPalindrome[i][j] = true;
                    if (len > maxLen) {
                        maxLen = len;
                        result = s.substring(j, i + 1);
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }
        return result;
    }
}