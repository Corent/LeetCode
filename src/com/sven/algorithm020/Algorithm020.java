package com.sven.algorithm020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algorithm020 {
}

class Solution {

    private Map<Character, Character> map = new HashMap<Character, Character>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.empty()) stack.push(c);
            else {
                Character h = map.get(c);
                if (h == null) stack.push(c);
                else {
                    if (!h.equals(stack.peek())) stack.push(c);
                    else stack.pop();
                }
            }
        }
        return stack.empty();
    }
}