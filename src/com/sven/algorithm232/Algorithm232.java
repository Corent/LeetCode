package com.sven.algorithm232;

import java.util.Stack;

public class Algorithm232 {
}

class MyQueue {

    private int state = 0;
    private Stack<Integer>[] stacks;

    /** Initialize your data structure here. */
    public MyQueue() {
        stacks = new Stack[2];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (state == 1) {
            while (!stacks[1].isEmpty()) stacks[0].push(stacks[1].pop());
            state = 0;
        }
        stacks[0].push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (state == 0) {
            while (!stacks[0].isEmpty()) stacks[1].push(stacks[0].pop());
            state = 1;
        }
        return stacks[1].pop();
    }

    /** Get the front element. */
    public int peek() {
        if (state == 0) {
            while (!stacks[0].isEmpty()) stacks[1].push(stacks[0].pop());
            state = 1;
        }
        return stacks[1].peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stacks[state].isEmpty();
    }
}

/**
 * 剑指Offer 面试题7
 */
class MyQueue2 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}