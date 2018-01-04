package com.sven.algorithm032;

import java.util.Stack;

public class Algorithm032 {
}

/**
 * http://blog.csdn.net/worldwindjp/article/details/39460161 超时
 * https://segmentfault.com/a/1190000003481194 动态规划
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        if (s.indexOf(')') == -1) return 0; // important
        int ans = 0, start = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.empty()) start = i;
                else {
                    stack.pop();
                    ans = Math.max(ans, i - (stack.empty()? start: stack.peek()));
                }
            }
        }
        return ans;
    }
}