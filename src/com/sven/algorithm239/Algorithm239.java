package com.sven.algorithm239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Algorithm239 {
}

/**
 * queue 存储当前窗口内最大致的下标，queue内的单个位置的数可能对应窗口中多个数
 *
 * 剑指Offer 面试题65
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < k || k <= 0) return new int[0];

        int idx = 0;
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(k);
        for (int i = 0, n = nums.length; i < n; i++) {
            if (!queue.isEmpty() && (i - queue.peekFirst() == k)) queue.pollFirst();
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
            if (i >= (k - 1)) ans[idx++] = nums[queue.peekFirst()];
        }

        return ans;
    }
}