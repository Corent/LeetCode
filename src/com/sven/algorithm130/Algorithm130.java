package com.sven.algorithm130;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm130 {
}

class Solution {

    private int m;
    private int n;
    private char[][] board;

    public void solve(char[][] board) {
        if (null == board) return;
        this.m = board.length;
        if (m == 0) return;
        this.n = board[0].length;
        if (n == 0) return;
        this.board = board;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') process(i, 0);
            if (board[i][n - 1] == 'O') process(i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') process(0, j);
            if (board[m - 1][j] == 'O') process(m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }

    private void process(int i, int j) {

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(i, j));
        board[i][j] = 'E';
        while (!que.isEmpty()) {
            Point p = que.poll();
            int x = p.x, y = p.y;
            if (x > 0 && board[x - 1][y] == 'O') {
                que.add(new Point(x - 1, y));
                board[x - 1][y] = 'E';
            }
            if (x < m - 1 && board[x + 1][y] == 'O') {
                que.add(new Point(x + 1, y));
                board[x + 1][y] = 'E';
            }
            if (y > 0 && board[x][y - 1] == 'O') {
                que.add(new Point(x, y - 1));
                board[x][y - 1] = 'E';
            }
            if (y < n - 1 && board[x][y + 1] == 'O') {
                que.add(new Point(x, y + 1));
                board[x][y + 1] = 'E';
            }
        }
    }

    class Point {
        public int x;
        public int y;
        public Point( int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}