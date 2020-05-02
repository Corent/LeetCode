package com.sven.algorithm407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Algorithm407 {
}

/**
 * https://blog.csdn.net/allenlzcoder/article/details/80294734
 * https://blog.csdn.net/yysave/article/details/92809515
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        if (heightMap[0].length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length, ans = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(1, Comparator.comparingInt(a -> a[2]));

        boolean[][] visited = new boolean[m][n];

        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.offer(new int[] {i, 0, heightMap[i][0]});
            queue.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.offer(new int[] {0, i, heightMap[0][i]});
            queue.offer(new int[] {m - 1, i, heightMap[m - 1][i]});
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
        // add all its neighbors to the queue.
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int row = cell[0] + dir[0], col = cell[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    visited[row][col] = true;
                    ans += Math.max(0, cell[2] - heightMap[row][col]);
                    queue.offer(new int[] {row, col, Math.max(heightMap[row][col], cell[2])});
                }
            }
        }

        return ans;
    }
}