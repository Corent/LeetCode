package com.sven.algorithm036;

import java.util.Arrays;

public class Algorithm036 {
}

/**
 * 每一行/列/九宫格依次校验
 */
class Solution {

    private boolean isValid(boolean[] visited, char ch) {
        if (ch == '.') return true;
        int idx = ch - '1';
        if (idx < 0 || idx > 8 || visited[idx]) return false;
        return visited[idx] = true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] visited = new boolean[3][9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited[0], false);
            Arrays.fill(visited[1], false);
            Arrays.fill(visited[2], false);
            int m = (i / 3) * 3, n = (i % 3) * 3;
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited[0], board[i][j]))
                    return false;
                if (!isValid(visited[1], board[j][i]))
                    return false;
                if (!isValid(visited[2], board[m + j / 3][n + j % 3]))
                    return false;
            }
        }

        return true;
    }
}