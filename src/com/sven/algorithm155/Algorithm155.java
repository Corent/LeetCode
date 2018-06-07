package com.sven.algorithm155;

import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm155 {
}

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> mStack;

    public MinStack() {
        stack = new Stack<>();
        mStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (mStack.isEmpty()) mStack.push(x);
        else mStack.push(Math.min(mStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        mStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }
}