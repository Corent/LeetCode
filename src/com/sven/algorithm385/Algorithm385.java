package com.sven.algorithm385;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Algorithm385 {

    public static void main(String[] args) {
        NestedInteger ni = new Solution().deserialize("[123,[456,[789]]]");
        System.out.println();
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {

    private Integer value;
    private List<NestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {}

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() { return value != null; }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() { return list != null ? value : null; }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) { this.value = value; }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (list == null) list = new ArrayList<>();
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() { return value != null ? list : null; }
}

/**
 * 三种情况
 * 1. 只有value
 * 2. 只有list
 * 3. value list都有
 */
class Solution {

    public NestedInteger deserialize(String s) {
        NestedInteger ni = new NestedInteger();
        if (s == null || s.length() == 0) return ni;
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        s = s.substring(1, s.length() - 1);
        int deep = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                deep++;
                continue;
            }
            if (ch == ']') deep--;
            if (deep == 0) {
                if (ch == ',') {
                    ni.add(deserialize(s.substring(start, i)));
                    start = i + 1;
                } else if (i == s.length() - 1)  {
                    ni.add(deserialize(s.substring(start, i + 1)));
                }
            }
        }

        return ni;
    }
}