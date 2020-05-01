package com.sven.algorithm384;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;

public class Algorithm384 {
}

class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int n: nums) list.add(n);
        int[] ans = new int[nums.length];
        int idx = 0;
        while (!list.isEmpty()) {
            int pos = random.nextInt(list.size());
            ans[idx++] = list.get(pos);
            list.remove(pos);
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */