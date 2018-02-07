package com.sven.algorithm057;

import java.util.ArrayList;
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

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
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