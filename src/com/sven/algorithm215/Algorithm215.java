package com.sven.algorithm215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm215 {

    public static void main(String[] args) {
        System.out.println(new Solution2().findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2) == 5);
        System.out.println(new Solution2().findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4) == 4);
        System.out.println(new Solution2().findKthLargest(new int[] { 2, 1 }, 1) == 2);
        System.out.println(new Solution2().findKthLargest(new int[] { 5, 2, 4, 1, 3, 6, 0 }, 4) == 3);
    }
}

/**
 * 堆排序
 */
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

/**
 *  基于快排
 */
class Solution2 {

    private int idx;
    private int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.idx = nums.length - k;
        return findKthLargest(0, nums.length - 1);
    }

    // 在from - to范围内查找排序后位置为idx的元素
    private int findKthLargest(int from, int to) {
        while (from < to) {
            int i = from, j = to;
            while (i < j) {
                while (i < j && nums[j] >= nums[i]) j--;
                swap(i, j);
                while (i < j && nums[i] <= nums[j]) i++;
                swap(i, j);
            }
            if (i == idx) return nums[i];
            if (i < idx) from = i + 1;
            else to = i - 1;
        }
        return nums[from];
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }
}