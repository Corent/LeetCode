package com.sven.algorithm077;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/13
 */
public class Algorithm077 {
}

class Solution {

    private int[] nums;
    private List<Integer> current;
    private List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i + 1;
        current = new ArrayList<>();
        ans = new ArrayList<>();
        pick(0, k);
        return ans;
    }

    private void pick(int from, int k) {
        if (nums.length - from < k) return;
        if (k == 0) {
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