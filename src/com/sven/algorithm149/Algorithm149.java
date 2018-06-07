package com.sven.algorithm149;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/6
 */
public class Algorithm149 {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0), p2 = new Point(94911151,94911150), p3 = new Point(94911152,94911151);
        Point[] points = new Point[] {p1, p2, p3};
        System.out.println(new Solution().maxPoints(points));
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Solution {

    public int maxPoints(Point[] points) {

        Map<Double, Integer> map = new HashMap<>();

        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            map.clear();
            map.put(Double.valueOf(Integer.MIN_VALUE), 0);
            int duplicate = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                    continue;
                }

                double k = points[i].x == points[j].x? Double.MAX_VALUE:
                        ((double)(points[j].y - points[i].y) / (points[j].x - points[i].x));
                int cnt = map.containsKey(k)? map.get(k): 0;
                map.put(k, cnt + 1);
            }
            for (Map.Entry<Double, Integer> entry: map.entrySet()) {
                ans = Math.max(ans, entry.getValue() + duplicate);
            }
        }

        return ans;
    }
}