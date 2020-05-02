package com.sven.algorithm405;

import java.util.LinkedList;
import java.util.Stack;

public class Algorithm405 {
}

class Solution {

    private String[] hex = new String[] {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
    };

    public String toHex(int num) {
        if (num == 0) return "0";
        Stack<String> stack = new Stack<>();
        int cnt = 0;
        while (num != 0 && cnt < 8) {
            stack.push(hex[num & 0xf]);
            num >>= 4;
            cnt++;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        return builder.toString();
    }
}