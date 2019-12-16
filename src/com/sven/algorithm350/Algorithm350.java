package com.sven.algorithm350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Algorithm350 {
}

class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Map<Integer, Integer> counter1 = new HashMap<>();
        Arrays.stream(nums1).forEach(n -> {
            set1.add(n);
            int cnt = counter1.containsKey(n)? counter1.get(n) + 1: 1;
            counter1.put(n, cnt);
        });

        Set<Integer> set2 = new HashSet<>();
        Map<Integer, Integer> counter2 = new HashMap<>();
        Arrays.stream(nums2).forEach(n -> {
            set2.add(n);
            int cnt = counter2.containsKey(n)? counter2.get(n) + 1: 1;
            counter2.put(n, cnt);
        });

        set1.retainAll(set2);
        List<Integer> list = new ArrayList<>();
        for (int n: set1) {
            int cnt = Math.min(counter1.get(n), counter2.get(n));
            while (cnt-- > 0) list.add(n);
        }

        int idx = 0;
        int[] ans = new int[list.size()];
        for (int n: list) ans[idx++] = n;
        return ans;
    }
}

class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> counter = new HashMap<>();
        Arrays.stream(nums1).forEach(n -> {
            int cnt = counter.containsKey(n)? counter.get(n) + 1: 1;
            counter.put(n, cnt);
        });

        List<Integer> list = new ArrayList<>();
        for (int n: nums2) {
            if (counter.containsKey(n)) {
                list.add(n);
                int cnt = counter.get(n);
                if (--cnt == 0) {
                    counter.remove(n);
                } else {
                    counter.put(n, cnt);
                }
            }
        }

        int idx = 0;
        int[] ans = new int[list.size()];
        for (int n: list) ans[idx++] = n;
        return ans;
    }
}