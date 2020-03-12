package com.sven.algorithm085;

import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm085 {
}

/**
 * 转换为上一题的问题
 * heights[i][j]表示前i行，位置j上的最大高度
 */
class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, ans = 0;
        if (m == 0) return ans;
        int n = matrix[0].length;
        if (n == 0) return ans;
        int[] height = new int[n];
        int[][] heights = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = i == 0? (matrix[i][j] - '0'): (matrix[i][j] == '0'? 0: heights[i - 1][j] + 1);
                height[j] = heights[i][j];
            }
            ans = Math.max(ans, largestRectangleArea(height));
        }
        return ans;
    }

    private int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, len = height.length; i <= len; i++) {
            int curt = (i == len)? -1: height[i];
            while (stack.size() > 0 && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.size() == 0? i: i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}