package com.sven.algorithm304;

public class Algorithm304 {
}

class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        if (m == 0) return;

        sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) sum[i][j] = matrix[i][j];
                else if (i == 0) sum[i][j] = sum[i][j - 1] + matrix[i][j];
                else if (j == 0) sum[i][j] = sum[i - 1][j] + matrix[i][j];
                else sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) return 0;
        if (row1 == 0 && col1 == 0) return sum[row2][col2];
        if (row1 == 0) return sum[row2][col2] - sum[row2][col1 - 1];
        if (col1 == 0) return sum[row2][col2] - sum[row1 - 1][col2];
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }
}