package com.sven.algorithm349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algorithm349 {
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(nums1).forEach(n -> set1.add(n));
        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(nums2).forEach(n -> set2.add(n));
        set1.retainAll(set2);
        int idx = 0;
        int[] ans = new int[set1.size()];
        for (int n: set1) {
            ans[idx++] = n;
        }
        return ans;
    }
}