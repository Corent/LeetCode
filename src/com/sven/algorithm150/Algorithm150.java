package com.sven.algorithm150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm150 {
}

class Solution {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token: tokens) {
            Integer a = null, b = null;
            switch (token) {
                case "+":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a + b));
                    break;
                case "-":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a - b));
                    break;
                case "*":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a * b));
                    break;
                case "/":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a / b));
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        return Integer.valueOf(stack.pop());
    }
}