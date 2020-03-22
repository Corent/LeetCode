package com.sven.algorithm179;

import java.util.Arrays;

public class Algorithm179 {
}

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder builder = new StringBuilder();
        if (nums == null || nums.length == 0) return "";
        Integer[] numss = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) numss[i] = nums[i];
        Arrays.sort(numss, (a, b) -> {
            Long ab = Long.valueOf(String.valueOf(a + "" + b));
            Long ba = Long.valueOf(String.valueOf(b + "" + a));
            return Long.valueOf(ba - ab).intValue();
        });
        int idx = 0;
        while (numss[idx] == 0 && idx < numss.length - 1) idx++;
        while (idx < numss.length) builder.append(numss[idx++]);
        return builder.toString();
    }
}