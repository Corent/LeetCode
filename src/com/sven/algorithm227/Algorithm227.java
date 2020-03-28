package com.sven.algorithm227;

import java.util.LinkedList;
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

class Solution2 {

    private LinkedList<Integer> nums = new LinkedList<>();
    private LinkedList<Character> operators = new LinkedList<>();

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        for (int i = 0, n = chs.length; i < n; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                int num = 0;
                while (i < n && chs[i] >= '0' && chs[i] <= '9') num = 10 * num + chs[i++] - '0';
                i--;
                nums.addLast(num);
                if (!operators.isEmpty() && (operators.peekLast() == '*' || operators.peekLast() == '/')) { //  优先计算乘除
                    calculateRight();
                }
                continue;
            }

            switch (chs[i]) {
                case '+': case '-': case '*': case '/': //  乘除号最深只能到栈顶
                    operators.addLast(chs[i]);
                    break;
                default:
                    break;
            }
        }

        while (!operators.isEmpty() && nums.size() > 1) {   //  计算加减
            calculateLeft();
        }

        return nums.pop();
    }

    private void calculateLeft() {
        if (nums.size() < 2 || operators.isEmpty()) return;
        char op = operators.pollFirst();
        int m = nums.pollFirst(), n = nums.pollFirst();
        System.out.print(new StringBuffer().append(n).append(op).append(n).toString());
        switch (op) {
            case '+':
                nums.addFirst(m + n);
                break;
            case '-':
                nums.addFirst(m - n);
                break;
            default: break;
        }
    }

    private void calculateRight() {
        if (nums.size() < 2 || operators.isEmpty()) return;
        char op = operators.pollLast();
        int m = nums.pollLast(), n = nums.pollLast();
        System.out.print(new StringBuffer().append(n).append(op).append(m).toString());
        switch (op) {
            case '*':
                nums.addLast(n * m);
                break;
            case '/':
                nums.addLast(n / m);
                break;
            default: break;
        }
    }
}