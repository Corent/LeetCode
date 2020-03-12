package com.sven.algorithm057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 06/02/2018
 */
public class Algorithm057 {
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

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (null == intervals || intervals.size() == 0) return new ArrayList<Interval>() {{ add(newInterval); }};
        if (newInterval == null) return intervals;
        List<Interval> ans = new ArrayList<>();
        int location = 0;
        for(Interval interval: intervals) {
            if (interval.end < newInterval.start) {
                ans.add(interval);
                location++;
            } else if (interval.start > newInterval.end) ans.add(interval);
            else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        ans.add(location, newInterval);
        return ans;
    }
}

class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null) return intervals;
        if (intervals == null || intervals.length == 0) return new int[][] {newInterval};
        LinkedList<int[]> intervalLinkedList = new LinkedList<>();
        Arrays.stream(intervals).forEach(i -> intervalLinkedList.addLast(i));
        ArrayList<int[]> finalIntervalLinkedList = new ArrayList<>();
        int idx = 0;
        for (int[] i: intervalLinkedList) {
            if (i[1] < newInterval[0]) {
                finalIntervalLinkedList.add(i);
                idx++;
            } else if (i[0] > newInterval[1]) finalIntervalLinkedList.add(i);
            else {
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);
            }
        }
        finalIntervalLinkedList.add(idx, newInterval);
        int[][] ans = new int[finalIntervalLinkedList.size()][2];
        for (int i = 0; i < finalIntervalLinkedList.size(); i++) {
            ans[i] = finalIntervalLinkedList.get(i);
        }
        return ans;
    }
}