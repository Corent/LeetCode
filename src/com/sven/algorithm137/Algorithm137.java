package com.sven.algorithm137;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/4
 */
public class Algorithm137 {
}

/**
 * https://blog.csdn.net/jiadebin890724/article/details/23306837
 */
class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; i++) {
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}