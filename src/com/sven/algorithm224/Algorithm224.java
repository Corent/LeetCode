package com.sven.algorithm224;

import java.util.Stack;

public class Algorithm224 {
}

class Solution {
    public int calculate(String s) {
        int ans = 0, sign = 1;
        if (s == null || s.length() == 0) return ans;
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, n = chs.length; i < n; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                int num = 0;
                while (i < n && chs[i] >= '0') num = 10 * num + chs[i++] - '0';
                ans += sign * num;
                i--;
                continue;
            }

            switch (chs[i]) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    stack.push(ans);
                    stack.push(sign);
                    ans = 0;
                    sign = 1;
                    break;
                case ')':
                    ans *= stack.pop();
                    ans += stack.pop();
                    break;
                default: break;
            }
        }

        return ans;
    }
}