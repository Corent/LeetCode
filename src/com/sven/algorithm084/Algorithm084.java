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

/**
 * 保持Stack内元素对应的高度严格升序，若遇到将要入栈的元素比栈顶小时，依次出栈，每次出栈计算已出栈部分和栈顶高度所围成的矩形面积
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, n = heights.length; i <= n; i++) {
            int curt = (i == n)? -1 : heights[i];
            while (!stack.isEmpty() && curt <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}