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
        boolean[] visited = new boolean[9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[i][j]))
                    return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            Arrays.fill(visited, false);
            for (int i = 0; i < 9; i++) {
                if (!isValid(visited, board[i][j]))
                    return false;
            }
        }

        for (int m = 0; m < 9; m++) {
            Arrays.fill(visited, false);
            int i = (m / 3) * 3, j = (m % 3) * 3;
            for (int n = 0; n < 9; n++) {
                if (!isValid(visited, board[i + n / 3][j + n % 3]))
                    return false;
            }
        }

        return true;
    }
}