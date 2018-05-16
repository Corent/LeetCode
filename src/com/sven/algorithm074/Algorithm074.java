package com.sven.algorithm074;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 08/05/2018
 */
public class Algorithm074 {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int i = mid / n, j = mid % n;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}