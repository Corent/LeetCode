package com.sven.algorithm037;

import java.util.ArrayList;
import java.util.List;

public class Algorithm037 {
}

/**
 * 递归回溯
 */
class Solution {

    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        core(0);
    }

    private boolean core(int step) {
        if (step == 81) return true;
        int r = step / 9, c = step % 9;
        if (board[r][c] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                board[r][c] = ch;
                if (check(step) && core(step + 1))
                    return true;
                board[r][c] = '.';
            }
        } else if (core(step + 1)) return true;
        return false;
    }

    private boolean check(int step) {
        int r = step / 9, c = step % 9;
        int m = r / 3 * 3, n = c / 3 * 3;
        for (int i = 0; i < 9; i++) {
            if (i != r && board[i][c] == board[r][c])
                return false;
            if (i != c && board[r][i] == board[r][c])
                return false;
            int a = m + i / 3, b = n + i % 3;
            if (a!= r && b != c && board[a][b] == board[r][c])
                return false;
        }
        return true;
    }
}