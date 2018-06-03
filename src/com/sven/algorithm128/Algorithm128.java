package com.sven.algorithm128;

import java.util.HashSet;
import java.util.Set;

public class Algorithm128 {
}

class Solution {
    public int longestConsecutive(int[] nums) {

        int ans = 0;
        if (nums == null || nums.length == 0) return ans;

        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int n: nums) set.add(n);
        for (int n: nums) {
            int prev = n - 1, next = n + 1;
            set.remove(n);
            while (set.remove(prev)) prev--;
            while (set.remove(next)) next++;
            ans = Math.max(ans, next - prev - 1);
        }
        return ans;
    }
}