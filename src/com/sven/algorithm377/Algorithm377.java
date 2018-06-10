package com.sven.algorithm377;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm377 {
}

class Solution {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n: nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}

/*
超时
class Solution {

    private int[] nums;
    private List<Integer> current;
    private List<List<Integer>> ans = new ArrayList<>();

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        this.nums = nums;
        current = new ArrayList<>(nums.length);
        combinationSum4Core(target);
        return ans.size();
    }

    private void combinationSum4Core(int target) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int n: nums) {
            current.add(n);
            combinationSum4Core(target - n);
            current.remove(current.size() - 1);
        }
    }
}*/
