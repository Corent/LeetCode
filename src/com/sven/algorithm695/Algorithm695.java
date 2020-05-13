package com.sven.algorithm695;

import java.util.LinkedList;

public class Algorithm695 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,0,1,1},
            {0,0,0,1,1}
        };

        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}

class Solution {

    private int[][] grid;
    private int ans = 0;
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j) {
        if (i < 0 || i >= m || i < 0 || j >= n || grid[i][j] <= 0) return;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] { i, j });
        grid[i][j] = -1;
        int curArea = 1;
        while (!queue.isEmpty()) {
            int[] pair = queue.pollFirst();
            grid[pair[0]][pair[1]] = -1;
            if (pair[0] > 0 && grid[pair[0] - 1][pair[1]] > 0) {
                queue.addLast(new int[] { pair[0] - 1, pair[1] });
                grid[pair[0] - 1][pair[1]] = -1;
                curArea++;
            }
            if (pair[0] < m - 1 && grid[pair[0] + 1][pair[1]] > 0) {
                queue.addLast(new int[] { pair[0] + 1, pair[1] });
                grid[pair[0] + 1][pair[1]] = -1;
                curArea++;
            }
            if (pair[1] > 0 && grid[pair[0]][pair[1] - 1] > 0) {
                queue.addLast(new int[] { pair[0], pair[1] - 1 });
                grid[pair[0]][pair[1] - 1] = -1;
                curArea++;
            }
            if (pair[1] < n - 1 && grid[pair[0]][pair[1] + 1] > 0) {
                queue.addLast(new int[] { pair[0], pair[1] + 1 });
                grid[pair[0]][pair[1] + 1] = -1;
                curArea++;
            }
        }
        ans = Math.max(ans, curArea);
    }
}