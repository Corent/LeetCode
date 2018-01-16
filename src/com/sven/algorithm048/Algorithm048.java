package com.sven.algorithm048;

public class Algorithm048 {
}

/**
 * 扇形，旋转
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp;
                int[] x = new int[4], y = new int[4];
                x[0] = i;
                y[0] = j;
                x[1] = y[0];
                y[1] = n - 1 - x[0];
                x[2] = y[1];
                y[2] = n - 1 - x[1];
                x[3] = y[2];
                y[3] = n - 1 - x[2];
                tmp = matrix[x[3]][y[3]];
                for (int k = 3; k > 0; k--) {
                    matrix[x[k]][y[k]] = matrix[x[k - 1]][y[k - 1]];
                }
                matrix[x[0]][y[0]] = tmp;
            }
        }
    }
}