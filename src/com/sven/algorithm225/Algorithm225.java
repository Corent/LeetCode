package com.sven.algorithm225;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm225 {
}

class MyStack {

    private int idx = 0;
    private Queue<Integer>[] queues;

    /** Initialize your data structure here. */
    public MyStack() {
        queues = new LinkedList[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queues[idx].add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queues[idx].size() > 1) {
            queues[1 - idx].add(queues[idx].poll());
        }
        idx = 1 - idx;
        return queues[1 - idx].poll();
    }

    /** Get the top element. */
    public int top() {
        int ans = 0;
        while (!queues[idx].isEmpty()) {
            ans = queues[idx].poll();
            queues[1 - idx].add(ans);
        }
        idx = 1 - idx;
        return ans;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queues[idx].isEmpty();
    }
}