package com.sven.algorithm216;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm216 {
}

class Solution {

    private int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    private List<Integer> current;
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n < 1 || n > 45) return ans;
        current = new ArrayList<>(k);
        combinationSum3Core(0, k, n);
        return ans;
    }

    private void combinationSum3Core(int from, int k, int n) {
        if (n < 0) return;
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (k == 0 || n == 0) return;
        for (int i = from; i <= nums.length - k; i++) {
            current.add(nums[i]);
            combinationSum3Core(i + 1, k - 1, n - nums[i]);
            current.remove(current.size() - 1);
        }
    }
}