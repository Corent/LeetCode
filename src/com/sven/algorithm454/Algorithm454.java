package com.sven.algorithm454;

import java.util.HashMap;
import java.util.Map;

public class Algorithm454 {
}

/**
 * DFS
 * 超时
 */
class Solution {

    private int ans  = 0;
    private int[][] ABCD;

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        ABCD = new int[][] { A, B, C, D };
        fourSumCount(0, 0);
        return ans;
    }

    private void fourSumCount(int level, int target) {
        if (level == ABCD.length) {
            if (target == 0) ans++;
            return;
        }

        for (int n: ABCD[level]) {
            fourSumCount(level + 1, target - n);
        }
    }
}

/**
 * https://www.cnblogs.com/liujinhong/p/6442573.html
 */
class Solution2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                ans += map.getOrDefault(-sum, 0);
            }
        }
        return ans;
    }
}