package com.sven.algorithm419;

public class Algorithm419 {
}

/**
 * 数船头
 * https://blog.csdn.net/camellhf/article/details/52871104
 */
class Solution {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        if (board == null || board.length == 0 || board[0].length == 0) return cnt;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.'))
                    cnt++;
            }
        }
        return cnt;
    }
}