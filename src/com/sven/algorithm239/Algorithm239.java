package com.sven.algorithm239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Algorithm239 {
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < k || k <= 0) return new int[0];

        List<Integer> list = new ArrayList<>(nums.length - k + 1);
        Deque<Integer> que = new ArrayDeque<>(k);
        for (int i = 0, n = nums.length; i < n; i++) {
            if (!que.isEmpty() && (i - que.peekFirst() == k)) que.pollFirst();
            while (!que.isEmpty() && nums[i] >= nums[que.peekLast()]) que.pollLast();
            que.add(i);
            if (i >= (k - 1)) list.add(nums[que.peekFirst()]);
        }

        int m = list.size();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) ans[i] = list.get(i);
        return ans;
    }
}