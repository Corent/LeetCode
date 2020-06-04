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

class Interval implements Comparable<Interval> {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    Interval(int[] nums) {
        start = nums[0];
        end = nums[1];
    }

    @Override
    public int compareTo(Interval o) {
        if (start != o.start) return Integer.valueOf(start).compareTo(o.start);
        return Integer.valueOf(end).compareTo(o.end);
    }
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

class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        LinkedList<Interval> intervalList = new LinkedList<>();
        List<Interval> finalIntervalList = new ArrayList<>();
        Arrays.stream(intervals).forEach(i -> intervalList.add(new Interval(i)));
        Collections.sort(intervalList);
        Interval current = null;
        while (!intervalList.isEmpty()) {
            if (current == null) {
                current = intervalList.pollFirst();
                continue;
            }

            if (current.end >= intervalList.peekFirst().start) {
                Interval next = intervalList.pollFirst();
                current.end = Math.max(current.end, next.end);
            } else {
                finalIntervalList.add(current);
                current = null;
            }
        }
        if (current != null) finalIntervalList.add(current);
        int[][] ans = new int[finalIntervalList.size()][2];
        for (int i = 0; i < finalIntervalList.size(); i++) {
            Interval interval = finalIntervalList.get(i);
            ans[i] = new int[] { interval.start, interval.end };
        }
        return ans;
    }
}

class Solution3 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        List<int[]> intervalList = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] current = null;
        for (int[] interval: intervals) {
            if (current == null) {
                current = interval;
                continue;
            }

            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                intervalList.add(current);
                current = interval;
            }
        }
        if (current != null) {
            intervalList.add(current);
        }
        int[][] ans = new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++) {
            ans[i] = intervalList.get(i);
        }
        return ans;
    }
}