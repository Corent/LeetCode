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
 * https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a
 */
class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;   //记录只出现过1次的bits、只出现过2次的bits、出现过3次的bits
        for (int i = 0; i < nums.length; i++) {
            two |= one & nums[i];   //要在更新ones前面更新twos
            one ^= nums[i];
            three = one & two;      //ones和twos中都为1即出现了3次
            one &= ~three;          //抹去出现了3次的bits
            two &= ~three;
        }
        return one;
    }
}