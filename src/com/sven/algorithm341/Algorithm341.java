package com.sven.algorithm341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Algorithm341 {
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    private List<Integer> nums;
    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        nums = new ArrayList<>();
        addNums(nestedList);
        it = nums.iterator();
    }

    private void addNums(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return;
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) nums.add(ni.getInteger());
            else addNums(ni.getList());
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

/**
 * https://blog.csdn.net/sheldonwong/article/details/78919279
 */
class NestedIterator2 implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack();

    public NestedIterator2(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1;i>=0;i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) return true;
            stack.pop();
            for(int i = ni.getList().size()-1;i>=0;i--){
                stack.push(ni.getList().get(i));
            }
        }
        return false;
    }
}