package com.sven.algorithm010;

public class Algorithm010 {
}

/**
 * http://blog.csdn.net/linhuanmars/article/details/21145563
 *
 * 剑指Offer 面试题53
 */
class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();

        // 1. p[j+1] != '*' 的情况
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {    //p[j+1]不可能是*，要么j已经是最后一个字符要么j+1字符不是*
            if (i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')) return false;    //s已经遍历到尾，或者s[i]与p[j]不匹配
            else return helper(s, p, i + 1, j + 1);
        }

        // 2. p[j+1] == '*' 的情况
        while (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {  //p[j+1]=='*'
            if (helper(s, p, i, j + 2)) return true;
            i++;
        }

        return helper(s, p, i, j + 2);  //匹配过*之后
    }
}

class Solution2 {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] matrix = new boolean[m][n]; //matrix[i][j]表示s的前i个字符与p的前j个字符是否匹配
        matrix[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) != '*') {
                for (int i = 0; i < m - 1; i++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                        matrix[i + 1][j + 1] = matrix[i][j];
                }
            } else {    //p[j] == '*'
                if (j < 1) continue;    //p="*"匹配不了任何字符串
                if (j > 0 && matrix[0][j - 1]) matrix[0][j + 1] = true; //s=""匹配了X*
                if (p.charAt(j - 1) == '.') {   // .* 的情况
                    int i = 0;
                    while (j > 0 && i < m - 1 && !matrix[i + 1][j - 1] && !matrix[i + 1][j]) i++;   //跳过不匹配的
                    for (; i < m - 1; i++) matrix[i + 1][j + 1] = true; //之后的都是能匹配
                } else {    //其他字符 X* 的情况
                    for (int i = 0; i < m - 1; i++) {
                        if (matrix[i + 1][j] || //*之前的都能匹配，即X*匹配1个
                                j > 0 && matrix[i + 1][j - 1] ||    //任意字符X之前的都能匹配，即X*匹配0个
                                i > 0 && j > 0 && matrix[i][j + 1] && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == p.charAt(j - 1)) {   // X* 匹配连续多个
                            matrix[i + 1][j + 1] = true;
                        }
                    }
                }
            }
        }
        return matrix[m - 1][n - 1];
    }
}