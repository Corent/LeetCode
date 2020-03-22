package com.sven.algorithm217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm217 {
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        return nums.length > Arrays.stream(nums).distinct().count();
    }
}

class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) return true;
            else set.add(n);
        }
        return false;
    }
}

class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}