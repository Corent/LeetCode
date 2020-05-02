package com.sven.algorithm402;

import java.util.LinkedList;
import java.util.Stack;

public class Algorithm402 {
}

class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            while (!list.isEmpty() && list.peekLast() > n && k > 0) {
                list.pollLast();
                k--;
            }
            if (n != 0 || !list.isEmpty()) list.addLast(n);
        }
        while (!list.isEmpty() && k-- > 0) list.pollLast();
        String ans = list.stream().map(String::valueOf).reduce("", (a, b) -> a + b);
        return ans.equals("") ? "0" : ans;
    }
}