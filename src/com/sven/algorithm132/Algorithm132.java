package com.sven.algorithm132;

import java.util.ArrayList;
import java.util.List;

public class Algorithm132 {
}

/**
 * isPalin[i][j]表示子串s[i-j]是否是回文
 * dp[i]表示以i位置为结尾的子串的最小切割数
 */
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        char[] chs = s.toCharArray();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
            if (i + 1 < n) isPalin[i][i + 1] = (chs[i] == chs[i + 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalin[i][j] = isPalin[i + 1][j - 1] && (chs[i] == chs[j]);
            }
        }
        dp[0] = -1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}

/*
class Solution {

    private String s;
    private Integer n;
    private Integer ans = Integer.MAX_VALUE;
    private List<String> current = new ArrayList<>();

    private boolean isPalindrome(int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) return false;
            from++;
            to--;
        }
        return true;
    }

    private void partitionCore(int from) {
        if (from == n) {
            ans = Math.min(ans, current.size() - 1);
            return;
        }
        for (int to = from; to < n; to++) {
            if (isPalindrome(from, to)) {
                current.add(s.substring(from, to + 1));
                partitionCore(to + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public int minCut(String s) {
        if (s == null) return 0;
        n = s.length();
        if (n == 0) return 0;
        this.s = s;
        partitionCore(0);
        return ans;
    }
}*/
