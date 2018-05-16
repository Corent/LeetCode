package com.sven.algorithm079;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/13
 */
public class Algorithm079 {
}

class Solution {

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return true;

        char c = word.charAt(0);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == c) {
                    if (find(board, i, j, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int start) {

        if (start == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(start) != board[i][j]) return false;

        board[i][j] = '#';
        boolean ans = find(board, i - 1, j, word, start + 1)
                || find(board, i + 1, j, word, start + 1)
                || find(board, i, j - 1, word, start + 1)
                || find(board, i, j + 1, word, start + 1);
        board[i][j] = word.charAt(start);
        return ans;
    }
}