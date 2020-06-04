package com.sven.algorithm1029;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithm1029 {
}

/**
 * O(nlogn)
 */
class Solution {

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            ans += i < costs.length / 2 ? costs[i][0] : costs[i][1];
        }
        return ans;
    }
}

/**
 * 基于快排的partition函数 O(logn)
 */
class Solution2 {

    private int[][] costs;

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        this.costs = costs;
        int left = 0, right = costs.length - 1, N = costs.length / 2;
        while (left < right) {  //  find idx = N
            int i = left, j = right;
            while (i < j) {
                while (i < j && compare(costs[i], costs[j]) <= 0) j--;
                swap(i, j);
                while (i < j && compare(costs[i], costs[j]) <= 0) i++;
                swap(i, j);
            }
            if (i == N) break;
            if (i < N) left = i + 1;
            else right = i - 1;
        }
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            ans += i < N ? costs[i][0] : costs[i][1];
        }
        return ans;
    }

    private int compare(int[] a, int[] b) {
        return (a[0] - a[1]) - (b[0] - b[1]);
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int[] tmp = costs[i];
        costs[i] = costs[j];
        costs[j] = tmp;
    }
}