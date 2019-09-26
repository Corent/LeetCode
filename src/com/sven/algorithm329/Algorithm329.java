package com.sven.algorithm329;

public class Algorithm329 {
}

class Solution {

    private int m;
    private int n;
    private int ans = 0;
    private int[][] dp;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) return ans;
        m = matrix.length;
        if (m == 0) return ans;
        n = matrix[0].length;
        if (n == 0) return ans;

        this.dp = new int[m][n];
        this.matrix = matrix;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        return ans;
    }

    private int dfs(int x, int y) {
        if (dp[x][y] > 0) return dp[x][y];
        int nextLen = 0;
        if (x > 0 && matrix[x - 1][y] > matrix[x][y]) {
            nextLen = Math.max(nextLen, dfs(x - 1, y));
        }
        if (x < m - 1 && matrix[x + 1][y] > matrix[x][y]) {
            nextLen = Math.max(nextLen, dfs(x + 1, y));
        }
        if (y > 0 && matrix[x][y - 1] > matrix[x][y]) {
            nextLen = Math.max(nextLen, dfs(x, y - 1));
        }
        if (y < n - 1 && matrix[x][y + 1] > matrix[x][y]) {
            nextLen = Math.max(nextLen, dfs(x, y + 1));
        }
        dp[x][y] = 1 + nextLen;
        return dp[x][y];
    }
}