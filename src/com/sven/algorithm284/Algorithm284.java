package com.sven.algorithm284;

import java.util.Iterator;

public class Algorithm284 {
}

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> it;
    private boolean peeked;
    private int peekVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!peeked) {
            peeked = true;
            peekVal = it.next();
        }
        return peekVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peeked) {
            peeked = false;
            return peekVal;
        }
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return peeked || it.hasNext();
    }
}