package com.sven.algorithm435;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithm435 {
}

/**
 * dp[i]表示以intervals[i]结尾的不相互覆盖的子序列最大长度
 * https://blog.csdn.net/qq_17550379/article/details/82930991
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] dp = new int[intervals.length];
        int cnt = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            cnt = Math.max(cnt, dp[i]);
        }
        return intervals.length - cnt;
    }
}

/**
 * Greedy
 */
class Solution2 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int ans = 0;
        int[] prev = null;
        for (int[] interval: intervals) {
            if (prev != null && prev[1] > interval[0]) {
                ans++;
                if (prev[1] > interval[1]) {
                    prev = interval;
                }
            } else prev = interval;
        }

        return ans;
    }
}