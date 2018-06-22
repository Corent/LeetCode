package com.sven.algorithm227;

import java.util.Stack;

public class Algorithm227 {

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
    }
}

class Solution {
    public int calculate(String s) {
        char op = '+';
        int ans = 0, num = 0;
        if (s == null || s.length() == 0) return ans;
        char[] chs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, n = chs.length; i < n; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                num = 10 * num + chs[i] - '0';
            }

            if (chs[i] < '0' && chs[i] != ' ' || i == n - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                op = chs[i];
                num = 0;
            }
        }

        while (!stack.isEmpty()) ans += stack.pop();

        return ans;
    }
}