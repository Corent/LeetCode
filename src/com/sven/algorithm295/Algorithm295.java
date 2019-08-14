package com.sven.algorithm295;

import java.util.PriorityQueue;

public class Algorithm295 {
}

class MedianFinder {

    private int size = 0;
    private PriorityQueue<Integer> maxTopHeap;
    private PriorityQueue<Integer> minTopHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxTopHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minTopHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        if (size == 0) maxTopHeap.add(num);
        else if (size == 1) {
            if (maxTopHeap.peek() <= num) minTopHeap.add(num);
            else {
                minTopHeap.add(maxTopHeap.poll());
                maxTopHeap.add(num);
            }
        } else {
            if (maxTopHeap.size() > size / 2) {
                if (num >= maxTopHeap.peek()) minTopHeap.add(num);
                else {
                    minTopHeap.add(maxTopHeap.poll());
                    maxTopHeap.add(num);
                }
            } else {
                if (num <= minTopHeap.peek()) maxTopHeap.add(num);
                else {
                    maxTopHeap.add(minTopHeap.poll());
                    minTopHeap.add(num);
                }
            }
        }
        size++;
    }

    public double findMedian() {
        return (size & 1) == 0? ((double) maxTopHeap.peek() + minTopHeap.peek()) / 2: maxTopHeap.peek();
    }
}