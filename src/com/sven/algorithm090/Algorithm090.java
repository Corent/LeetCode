package com.sven.algorithm090;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm090 {
}

class Solution {

    private int[] nums;
    private Set<String> set;
    private List<Integer> current;
    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        set = new HashSet<>();
        current = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) pick(0, i);
        return ans;
    }

    private void pick(int from, int k) {
        if (nums.length - from < k) return;
        if (k == 0) {
            String s = current.stream().map(String::valueOf).reduce("", (a, b) -> a + "|" + b);
            if (set.contains(s)) return;
            set.add(s);
            ans.add(new ArrayList<Integer>(current));
            return;
        }

        for (int i = from; i < nums.length; i++) {
            current.add(nums[i]);
            pick(i + 1, k - 1);
            current.remove(current.size() - 1);
        }
    }
}