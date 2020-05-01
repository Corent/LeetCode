package com.sven.algorithm388;

import java.util.Stack;

public class Algorithm388 {
}

/**
 * https://www.cnblogs.com/kexinxin/p/10235365.html
 */
class Solution {

    public int lengthLongestPath(String input) {
        // P1: 不可Stack<Integer>只存长度，你还需要记忆栈顶是第几层的，所以你要么两个stack要么stack<String>存整个。
        Stack<String> stack = new Stack<>();
        // P2: '\n', '\t'是一个字符而不是两个
        // P3: 先split成一行一行简单很多！
        // P4 string.split()和string.contains()里面只能填string不能char!一般还是都用""吧就sb.append可以用char
        String[] strs = input.split("\n");
        int ans = 0;
        int count = 0;

        for (String s : strs) {
            while (!stack.isEmpty() && level(s) <= level(stack.peek())) {
                String top = stack.pop();
                count -= (top.length() - level(top) + 1);
            }
            stack.push(s);
            // P5: +1是为了path里的'/', 对比时的-1是为了path最后没有'/'
            count += s.length() - level(s) + 1;
            if (s.contains(".")) {
                ans = Math.max(ans, count - 1);
            }
        }
        return ans;
    }

    // 有多少个 \t 开头就是多少层
    private int level(String s) {
        int i = 0, sum = 0;
        while (s.charAt(i++) == '\t') {
            sum++;
        }
        return sum;
    }
}