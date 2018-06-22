package com.sven.algorithm220;

import java.util.TreeSet;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/19
 */
public class Algorithm220 {
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0, n = nums.length; i < n; i++) {
            Long floor = treeSet.floor(Long.valueOf(nums[i]) + t);
            Long ceil = treeSet.ceiling(Long.valueOf(nums[i]) - t);

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                return true;

            treeSet.add(Long.valueOf(nums[i]));
            if (i >= k) treeSet.remove(Long.valueOf(nums[i - k]));
        }
        return false;
    }
}