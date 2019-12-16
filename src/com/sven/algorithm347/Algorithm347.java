package com.sven.algorithm347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Algorithm347 {
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            int cnt = counter.containsKey(num)? counter.get(num) + 1: 1;
            counter.put(num, cnt);
        }

        PriorityQueue<NumCnt> maxHeap = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
        for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
            maxHeap.add(new NumCnt(e.getKey(), e.getValue()));
        }

        List<Integer> ans = new ArrayList<>(k);
        while (!maxHeap.isEmpty() && k-- > 0) {
            ans.add(maxHeap.poll().num);
        }
        return ans;
    }

    class NumCnt {
        public int num;
        public int cnt;

        public NumCnt(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}