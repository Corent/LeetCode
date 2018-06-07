package com.sven.algorithm167;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm167 {
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int tmp = numbers[i] + numbers[j];
            if (tmp == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            } else if (tmp < target) i++;
            else j--;
        }
        return ans;
    }
}