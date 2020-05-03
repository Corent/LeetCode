package com.sven.algorithm452;

import java.util.Arrays;
import java.util.Comparator;

public class Algorithm452 {
}

/**
 * https://www.jianshu.com/p/31d06c53f76d
 */
class Solution {

    public int findMinArrowShots(int[][] points) {
        if (null == points || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int ans = 1;
        int end = points[0][1];
        for (int[] p : points) {
            if (p[0] > end) {
                ans++;
                end = p[1];
            } else end = Math.min(p[1], end);
        }
        return ans;
    }
}