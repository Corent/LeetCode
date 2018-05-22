package com.sven.algorithm081;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/17
 */
public class Algorithm081 {
}

class Solution {
    public boolean search(int[] nums, int target) {
        for (int n: nums) {
            if (n == target)
                return true;
        }
        return false;
    }
}