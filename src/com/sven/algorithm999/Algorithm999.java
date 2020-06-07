package com.sven.algorithm999;

public class Algorithm999 {
}

class Solution {

    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int m = board.length, n = board[0].length, ans = 0;

        Integer ri = null, rj = null, idx = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    ri = i;
                    rj = j;
                    break;
                }
            }
        }

        if (ri == null || rj == null) return ans;
        idx = ri - 1;
        while (idx >= 0 && board[idx][rj] == '.') idx--;
        if (idx >= 0 && board[idx][rj] == 'p') ans++;
        idx = ri + 1;
        while (idx < m && board[idx][rj] == '.') idx++;
        if (idx < m && board[idx][rj] == 'p') ans++;
        idx = rj - 1;
        while (idx >= 0 && board[ri][idx] == '.') idx--;
        if (idx >= 0 && board[ri][idx] == 'p') ans++;
        idx = rj + 1;
        while (idx < n && board[ri][idx] == '.') idx++;
        if (idx < n && board[ri][idx] == 'p') ans++;

        return ans;
    }
}