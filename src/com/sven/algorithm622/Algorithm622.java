package com.sven.algorithm622;

import java.util.Arrays;

public class Algorithm622 {
}

/**
 * 为解决front == rear牺牲一个位置
 * https://blog.csdn.net/varyall/article/details/82154323
 */
class MyCircularQueue {

    private int front;
    private int rear;
    private int[] nums;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        front = 0;
        rear = 0;
        nums = new int[k + 1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        nums[rear++] = value;
        rear %= nums.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        nums[front] = 0;
        front = (front + 1) % nums.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : nums[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : nums[(rear - 1 + nums.length) % nums.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1) % nums.length == front;
    }
}