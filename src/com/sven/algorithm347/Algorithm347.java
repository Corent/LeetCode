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
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int num: nums) {
            int cnt = counter.containsKey(num)? counter.get(num) + 1: 1;
            counter.put(num, cnt);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
            maxHeap.add(new int[] { e.getKey(), e.getValue() });
        }

        int n = Math.min(maxHeap.size(), k);
        int[] ans = new int[n];
        while (n > 0) {
            ans[--n] = maxHeap.poll()[0];
        }
        return ans;
    }
}