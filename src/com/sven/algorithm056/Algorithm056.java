package com.sven.algorithm056;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 06/02/2018
 */
public class Algorithm056 {

    public static void main(String[] args) {
        List<Interval> ans = new Solution().merge(new ArrayList<Interval>() {{
            /*add(new Interval(1, 3));
            add(new Interval(2, 6));
            add(new Interval(8, 10));
            add(new Interval(15, 18));*/
            add(new Interval(1, 4));
            add(new Interval(1, 4));
        }});
        ans.forEach(interval -> System.out.println("[" + interval.start + ", " + interval.end + "] "));
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

/**
 * 先排序，规则是先比较start再比较end
 * 这样一来，如果一个区间能与某些区间合并的话，这些区间中一定包含这个区间的下一个区间；如果一个区间不能与下一个区间合并，那么这个区间不能与其他任何区间合并
 * 遍历这有序区间序列，以第某一个为基准向后合并，不能合并时将合并结果放入结果集，取这个区间的下一个区间作为新基准
 */
class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return new ArrayList<>();
        if (intervals.size() < 2) return intervals;
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start != o2.start) return Integer.valueOf(o1.start).compareTo(o2.start);
            return Integer.valueOf(o1.end).compareTo(o2.end);
        });
        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); ) {
            Interval interval = intervals.get(i);
            if (i == intervals.size() - 1) {
                ans.add(interval);
                break;
            }
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval interval1 = intervals.get(j);
                if (!(interval.end < interval1.start || interval.start > interval1.end)) {
                    interval.start = Math.min(interval.start, interval1.start);
                    interval.end = Math.max(interval.end, interval1.end);
                    if (j == intervals.size() - 1) {
                        ans.add(interval);
                        i = j + 1;
                        break;
                    }
                } else {
                    ans.add(interval);
                    i = j;
                    break;
                }
            }
        }
        return ans;
    }
}