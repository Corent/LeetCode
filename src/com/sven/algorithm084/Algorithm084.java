package com.sven.algorithm084;

import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/18
 */
public class Algorithm084 {
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, len = heights.length; i <= len; i++) {
            int curt = (i == len)? -1: heights[i];
            while (stack.size() > 0 && curt <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.size() == 0? i: i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}