package com.sven.algorithm200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm200 {
}

class Solution {

    private int m;
    private int n;
    private char[][] grid;

    private void bfs(int i, int j) {
        Queue<Cell> cells = new LinkedList<>();
        cells.add(new Cell(i, j));
        grid[i][j] = '2';
        while (!cells.isEmpty()) {
            Cell cell = cells.poll();
            grid[cell.x][cell.y] = '0';
            if (cell.x - 1 >= 0 && grid[cell.x - 1][cell.y] == '1') {
                cells.add(new Cell(cell.x - 1, cell.y));
                grid[cell.x - 1][cell.y] = '2';
            }
            if (cell.y + 1 < n && grid[cell.x][cell.y + 1] == '1') {
                cells.add(new Cell(cell.x, cell.y + 1));
                grid[cell.x][cell.y + 1] = '2';
            }
            if (cell.x + 1 < m && grid[cell.x + 1][cell.y] == '1') {
                cells.add(new Cell(cell.x + 1, cell.y));
                grid[cell.x + 1][cell.y] = '2';
            }
            if (cell.y - 1 >= 0 && grid[cell.x][cell.y - 1] == '1') {
                cells.add(new Cell(cell.x, cell.y - 1));
                grid[cell.x][cell.y - 1] = '2';
            }
        }
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        this.m = grid.length;
        if (m == 0) return ans;
        this.n = grid[0].length;
        if (n == 0) return ans;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    class Cell {

        public int x;
        public int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}