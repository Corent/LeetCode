package com.sven.algorithm463;

public class Algorithm463 {
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = 0, n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    m++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) n++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) n++;
                }
            }
        }
        return m * 4 - n * 2;
    }
}