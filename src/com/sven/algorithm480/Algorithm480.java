package com.sven.algorithm480;

import java.util.Collections;
import java.util.PriorityQueue;

public class Algorithm480 {
}

class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            left.add(nums[i]);
            right.add(left.poll());
            if (right.size() > left.size()) {
                left.add(right.poll());
            }
            if (left.size() + right.size() == k) {
                int start = i - k + 1;
                ans[start] = (k & 1) != 0 ? left.peek() : 0.5 * ((double) left.peek() + (double) right.peek());
                if (!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return ans;
    }
}