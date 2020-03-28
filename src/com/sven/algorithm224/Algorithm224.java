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

/**
 * https://blog.csdn.net/king3wade/article/details/92757280
 */
class Solution2 {

    private Stack<Integer> nums = new Stack<>();
    private Stack<Character> operators = new Stack<>();

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        for (int i = 0, n = chs.length; i < n; i++) {
            switch (chs[i]) {
                case '+': case '-': case '(':
                    operators.push(chs[i]);
                    break;
                case ')':
                    if (operators.peek() == '(') {
                        operators.pop();
                        calculate();
                    }
                    break;
                default:
                    if (chs[i] >= '0' && chs[i] <= '9') {
                        int num = 0;
                        while (i < n && chs[i] >= '0' && chs[i] <= '9') num = 10 * num + chs[i++] - '0';
                        i--;
                        nums.push(num);
                        calculate();
                    }
                    break;
            }
        }

        return nums.peek();
    }

    private void calculate() {
        if (nums.size() < 2 || operators.isEmpty() || operators.peek() == '(') return;
        char op = operators.pop();
        int m = nums.pop(), n = nums.pop();
        switch (op) {
            case '+':
                nums.push(n + m);
                break;
            case '-':
                nums.push(n - m);
                break;
            default: break;
        }
    }
}