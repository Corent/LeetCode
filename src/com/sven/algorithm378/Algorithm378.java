package com.sven.algorithm378;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Algorithm378 {
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> maxTopHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n * n; i++) {
            int num = matrix[i / n][i % n];
            if (maxTopHeap.size() < k) {
                maxTopHeap.add(num);
                continue;
            }
            if (num < maxTopHeap.peek()) {
                maxTopHeap.poll();
                maxTopHeap.add(num);
            }
        }
        return maxTopHeap.peek();
    }
}

/**
 * https://blog.csdn.net/fisherming/article/details/79908207
 */
class Solution2 {

    private int n;
    private int k;
    private int[][] matrix;

    public boolean guess(int g) {
        int sum = 0;
        for (int i = 0; i < n; i++){
            int L = 0, R = n - 1, ans = 0;
            while (L <= R) {
                int mid = L + ((R - L) >> 1);
                if (matrix[i][mid] < g) { //若某一行值小于g，则应该是最后一个元素的下标 + 1
                    ans = mid + 1;
                    L = mid + 1;
                } else R = mid - 1;
            }
            sum += ans;
        }
        return k > sum;
    }

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.k = k;
        int L = matrix[0][0], R = matrix[n - 1][n - 1], ans = 0;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (guess(mid)) {
                ans = mid;
                L = mid + 1;
            } else R = mid - 1;
        }
        return ans;
    }
}