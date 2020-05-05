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
        int ans = 1, end = points[0][1];    //  end是前面相同起点的气球的公共区间右端点，如果有右侧的气球重合，更新为右侧重合气球的最左端最小值
        for (int[] p : points) {
            if (p[0] > end) {
                ans++;
                end = p[1];
            } else end = Math.min(p[1], end);
        }
        return ans;
    }
}