package com.sven.algorithm078;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/13
 */
public class Algorithm078 {
}

class Solution {

    private int[] nums;
    private List<Integer> current;
    private List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        current = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) pick(0, i);
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