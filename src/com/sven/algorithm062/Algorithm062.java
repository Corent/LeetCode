package com.sven.algorithm062;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 09/02/2018
 */
public class Algorithm062 {

    public static void main(String[] args) {
        System.out.println(new Solution2().uniquePaths(2, 2));
    }
}

/**
 * 非常简单的dp
 */
class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = i == 0 || j == 0? 1: dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
/**
 * 溢出
 * C(m + n - 2, min(m - 1, n - 1))
 */
class Solution2 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int total = m + n - 2, min = Math.min(m - 1, n - 1);
        return factorial(min) * factorial(total - min);
    }

    private int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) ans *= i;
        return ans;
    }
}

/**
 * 递归回溯
 * 超时
 */
class Solution3 {
    private int ans = 0;

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        findPath(m - 1, n - 1);
        return ans;
    }

    private void findPath(int m, int n) {
        if (m == 0 || n == 0) {
            ans++;
            return;
        }
        findPath(m - 1, n);
        findPath(m, n - 1);
    }
}