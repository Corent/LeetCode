package com.sven.algorithm1381;

public class Algorithm1381 {
}

class CustomStack {

    private int idx = -1;
    private int[] stack;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (idx == stack.length - 1) return;
        stack[++idx] = x;
    }

    public int pop() {
        return idx < 0 ? -1 : stack[idx--];
    }

    public void increment(int k, int val) {
        int cnt = Math.min(k, idx + 1);
        for (int i = 0; i < cnt; i++) stack[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */