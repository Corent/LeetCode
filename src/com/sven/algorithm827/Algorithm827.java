package com.sven.algorithm827;

import java.util.*;

public class Algorithm827 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestIsland(new int[][] {{1,0}, {0,1}}));
    }
}

/**
 * BFS 参考 Algorithm 695
 */
class Solution {

    private int[][] grid;
    private int ans = 0;
    private int m;
    private int n;

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        return ans == 0 ? m * n : ans;
    }

    private void bfs(int i, int j) {
        if (i < 0 || i >= m || i < 0 || j >= n || grid[i][j] != 0) return;
        LinkedList<int[]> queue = new LinkedList<>();
        List<int[]> coordinates = new ArrayList<>();
        queue.addLast(new int[] { i, j });
        grid[i][j] = -1;
        int curArea = 1;
        while (!queue.isEmpty()) {
            int[] pair = queue.pollFirst();
            coordinates.add(pair);
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
        coordinates.forEach(pair -> grid[pair[0]][pair[1]] = 1);
        grid[i][j] = -curArea;
        ans = Math.max(ans, curArea);
    }
}


class Solution2 {

    private int[][] grid;
    private int[][] islands;
    private Map<Integer, Integer> islandArea = new HashMap<>();
    private int ans = 0;
    private int num = 0;
    private int m;
    private int n;

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.islands = new int[m][n];
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j);
                } else if (grid[i][j] == 0) {
                    zeros.add(new int[] { i, j });
                }
            }
        }

        for (int[] pair: zeros) {
            int curArea = 1;
            Set<Integer> set = new HashSet<>();
            if (pair[0] > 0 && grid[pair[0] - 1][pair[1]] < 0) {
                set.add(islands[pair[0] - 1][pair[1]]);
            }
            if (pair[0] < m - 1 && grid[pair[0] + 1][pair[1]] < 0) {
                set.add(islands[pair[0] + 1][pair[1]]);
            }
            if (pair[1] > 0 && grid[pair[0]][pair[1] - 1] < 0) {
                set.add(islands[pair[0]][pair[1] - 1]);
            }
            if (pair[1] < n - 1 && grid[pair[0]][pair[1] + 1] < 0) {
                set.add(islands[pair[0]][pair[1] + 1]);
            }

            for (int s: set) {
                curArea += islandArea.get(s);
            }
            ans = Math.max(ans, curArea);
        }

        return ans == 0 ? m * n : ans;
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
            islands[pair[0]][pair[1]] = num;
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
        islandArea.put(num++, curArea);
    }
}