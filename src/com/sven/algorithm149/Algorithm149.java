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

/**
 * https://blog.csdn.net/lwycc2333/article/details/88427332
 * 将(y1-y2)/(x1-x2) == (y1-y)/(x1-x) 改写成判断 (y1-y2)*(y1-y) == (x1-x2)*(x1-x)
 */
class Solution2 {
    public int maxPoints(int[][] points) {

        int len = points.length, index1 = 0, index2 = 1, count = 0, maxCount = 0;
        if (len <= 2) return len;

        while (index1 < len && index2 < len) {
            if (points[index1][0] == points[index2][0]) { // 斜率为无穷
                for (int i = 0; i < len; i++){
                    if (points[i][0] == points[index2][0]) {
                        count++;
                    }
                }
            } else { //其他情况
                for (int i = 0; i < len; i++){
                    if (((long)(points[index1][1] - points[index2][1]) * (points[index1][0] - points[i][0])) == ((long)(points[index1][1] - points[i][1]) * (points[index1][0] - points[index2][0]))){
                        count++;
                        // System.out.println("[ "+points[i][0]+", "+points[i][0]+" ]");
                    }
                }
            }
            
            if (count == len) return len;
            if (maxCount < count) maxCount = count;
            count = 0;
            if (index2 < len - 1) index2++;
            else {
                index1++;
                index2 = index1 + 1;
            }

        }
        return maxCount;
    }
}