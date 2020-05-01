package com.sven.algorithm373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm373 {
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxTopHeap = new PriorityQueue<>((o1, o2) -> (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1)));
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < m * n; i++) {
            List<Integer> pair = new ArrayList<>();
            int a = nums1[i % m], b = nums2[i / m];
            pair.add(a);
            pair.add(b);
            if (maxTopHeap.size() < k) {
                maxTopHeap.add(pair);
            } else {
                List<Integer> peek = maxTopHeap.peek();
                if (a + b < peek.get(0) + peek.get(1)) {
                    maxTopHeap.poll();
                    maxTopHeap.add(pair);
                }
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        while (!maxTopHeap.isEmpty()) ((LinkedList<List<Integer>>) ans).addFirst(maxTopHeap.poll());
        return ans;
    }
}