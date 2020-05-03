package com.sven.algorithm436;

import java.util.TreeMap;

public class Algorithm436 {
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        int[] ans = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Integer idx = map.ceilingKey(intervals[i][1]);
            ans[i] = idx == null ? -1 : map.get(idx);
        }
        return ans;
    }
}