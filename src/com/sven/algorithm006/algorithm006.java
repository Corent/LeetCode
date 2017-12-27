package com.sven.algorithm006;

public class algorithm006 {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }
}

/**
 * 构造一个合适大小的矩阵，把字符依次填入，最后按顺序读取
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) return s;
        int m = numRows;
        int n = s.length() / (m * 2 - 2) + (s.length() % (m * 2 - 2) == 0? 0: 1);
        n *= (m - 1);
        Character[][] matrix = new Character[m][n];
        int x = 0, y = 0, xState = 1, yState = 0;  //xy是坐标，xState有-1和1即向上向下两种状态，yState有0和1即不变和向右两种状态
        for (int k = 0; k < s.length(); k++) {
            matrix[x][y] = s.charAt(k);
            if (x == m - 1 && xState == 1) {    //向下到底
                xState = -1;
                yState = 1;
            } else if (x == 0 && xState == -1) {    //向上到顶
                xState = 1;
                yState = 0;
            }
            x += xState;
            y += yState;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != null) {
                    builder.append(matrix[i][j]);
                }
            }
        }
        return builder.toString();
    }
}