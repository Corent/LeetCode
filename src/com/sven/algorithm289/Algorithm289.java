package com.sven.algorithm289;

public class Algorithm289 {
}

class Solution {

    private int m;
    private int n;

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCnt = liveNeighborCnt(board, i, j);
                if (board[i][j] == 1 && liveCnt >= 2 && liveCnt <= 3)
                    board[i][j] = 3;    //  必须是3，因为最低位的1还是会在 liveNeighborCnt() 方法中被用到
                if (board[i][j] == 0 && liveCnt == 3)
                    board[i][j] = 2;    //  同理，必须是2
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int liveNeighborCnt(int[][] board, int i, int j) {
        int liveCnt = 0;
        int xStart = Math.max(i - 1, 0), xEnd = Math.min(i + 1, m - 1);
        int yStart = Math.max(j - 1, 0), yEnd = Math.min(j + 1, n - 1);
        for (int x = xStart; x <= xEnd; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                liveCnt += board[x][y] & 1;
            }
        }
        liveCnt -= board[i][j] & 1;
        return liveCnt;
    }
}