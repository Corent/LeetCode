package com.sven.algorithm447;

import java.util.HashMap;
import java.util.Map;

public class Algorithm447 {
}

class Solution {

    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dis = dis(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Integer item: map.values()) {
                if (item >= 2) {
                    ans += item * (item - 1);
                }
            }
            map.clear();
        }
        return ans;
    }
}