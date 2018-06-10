package com.sven.algorithm215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm215 {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(/*(o1, o2) -> o2 - o1*/);
        for (Integer n: nums) {
            if (que.size() < k) que.add(n);
            else if (n > que.peek()) {
                que.poll();
                que.add(n);
            }
        }
        return que.peek();
    }
}