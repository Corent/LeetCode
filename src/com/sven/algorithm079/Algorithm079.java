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

/**
 * 剑指Offer 面试题66
 */
class Solution {

    private int m;
    private int n;
    private String word;

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return true;

        this.word = word;
        m = board.length;
        n = board[0].length;
        char c = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == c) {
                    if (find(board, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int i, int j, int start) {

        if (start == word.length()) return true;
        char ch = word.charAt(start);
        if (i < 0 || i >= m || j < 0 || j >= n || ch != board[i][j]) return false;

        board[i][j] = '#';
        boolean ans = find(board, i - 1, j, start + 1)
                || find(board, i + 1, j, start + 1)
                || find(board, i, j - 1, start + 1)
                || find(board, i, j + 1, start + 1);
        board[i][j] = ch;
        return ans;
    }
}