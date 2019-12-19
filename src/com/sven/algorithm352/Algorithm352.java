package com.sven.algorithm352;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Algorithm352 {
}

/**
 * https://www.cnblogs.com/godlei/p/5560204.html
 */
class SummaryRanges {

    private List<Interval> lists;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        lists = new ArrayList<Interval>();
    }

    public void addNum(int val) {
        if (lists.size() == 0){
            Interval p = new Interval(val, val);
            lists.add(p);
            return;
        }

        if (lists.size() == 1){
            if (lists.get(0).end < val){
                Interval p = lists.remove(0);
                if (p.end == val - 1){
                    Interval p1 = new Interval(p.start, val);
                    lists.add(p1);
                    return;
                }
                Interval p1 = new Interval(val, val);
                lists.add(p);
                lists.add(p1);
                return;
            } else if (lists.get(0).start > val){
                Interval p = lists.remove(0);
                if (p.start == val + 1){
                    Interval p1 = new Interval(val, p.start);
                    lists.add(p1);
                    return;
                }
                Interval p1 = new Interval(val, val);
                lists.add(p1);
                lists.add(p);
                return;
            } else {
                return;
            }
        }
        int pos = findIndex(val);
        if (pos == -1){
            if (val == lists.get(0).start - 1){
                lists.get(0).start = val;
                return;
            } else {
                Interval p1 = new Interval(val, val);
                lists.add(0, p1);
                return;
            }
        }
        if (pos == lists.size() - 1){
            if (val <= lists.get(pos).end){
                return;
            } else {
                if (val == lists.get(pos).end + 1){
                    lists.get(pos).end=val;
                    return;
                } else {
                    Interval p1 = new Interval(val, val);
                    lists.add(p1);
                    return;
                }
            }
        }

        if (val <= lists.get(pos).end){
            return;
        } else if (val == lists.get(pos + 1).start - 1 && val == lists.get(pos).end + 1){
            Interval p1 = lists.remove(pos);
            Interval p2 = lists.remove(pos);
            Interval p = new Interval(p1.start, p2.end);
            lists.add(pos, p);
            return;
        } else if (val == lists.get(pos + 1).start - 1){
            lists.get(pos + 1).start = val;
            return;
        } else if (val == lists.get(pos).end + 1){
            lists.get(pos).end = val;
            return;
        } else{
            Interval p = new Interval(val, val);
            lists.add(pos+1, p);
            return;
        }

    }

    public int[][] getIntervals() {
        int idx = 0;
        int[][] ans = new int[lists.size()][2];
        for (Interval i: lists) {
            ans[idx][0] = i.start;
            ans[idx][1] = i.end;
            idx++;
        }
        return ans;
    }

    private int findIndex(int val){
        int start = 0;
        int end = lists.size()-1;
        if (lists.get(0).start > val)
            return -1;
        if (lists.get(lists.size() - 1).start < val)
            return lists.size() - 1;
        while (start < end){
            int mid = (start + end) / 2;
            if (val < lists.get(mid).start){
                end = mid - 1;
            } else if (val > lists.get(mid).start){
                if (val < lists.get(mid + 1).start)
                    return mid;
                else
                    start = mid + 1;
            } else return mid;
        }
        return start;
    }

    class Interval {
        public int start;
        public int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */