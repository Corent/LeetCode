package com.sven.algorithm032;

import java.util.Stack;

public class Algorithm032 {
}

/**
 * http://blog.csdn.net/worldwindjp/article/details/39460161 超时
 * https://segmentfault.com/a/1190000003481194 动态规划
 *
 * 想要O(n)的解法需要一点技巧，栈中保存的不是‘(’而是‘(’所在的index，在此基础上也要弄清楚几种情况：
 * 每次来了‘(’之后，无条件压栈。如果碰到')'的话，如果栈不为空，就消除栈内剩余的'('
 * 第一：消除掉'('之后，如果栈内还有剩余的‘(’的话，最长的合法长度就是：maxLength = Math.max(i - (int)stack.peek() , maxLength);  也就是取：当前')'的index减去栈顶元素的index  和 原来max_length 两者的最大值。
 *
 * 例如：对于这种情况：()(()()，可以正确的得出最大值为4。
 *
 * 第二：消除掉')'之后，栈内没有剩余的‘(’了。此时需要引入一个新的变量start，用于表示合法括号字符串的起点。
 * 例如：对于这种情况：())()()，可以正确的得出最大值为4。
 *
 * start初始为-1，之后每次碰到‘)’且栈为空的时候更新为当前‘)’的index。也就是说无法消除的)之后的括号不可能再和前面的括号合并在一起计算最长序列，所以更新start。
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