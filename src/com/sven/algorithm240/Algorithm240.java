package com.sven.algorithm240;

public class Algorithm240 {
}

/**
 * 剑指Offer 面试题3
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }
}