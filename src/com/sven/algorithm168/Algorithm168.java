package com.sven.algorithm168;

import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm168 {
}

class Solution {

    private char[] chs = new char[] { 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y' };

    public String convertToTitle(int n) {
        Stack<Character> stack = new Stack<>();
        while (n != 0) {
            stack.push(chs[n % 26]);
            n = (n - 1) / 26;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}