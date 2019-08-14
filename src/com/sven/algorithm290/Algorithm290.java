package com.sven.algorithm290;

import java.util.HashMap;
import java.util.Map;

public class Algorithm290 {
}

class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        if (pattern.length() == 0) return str.equals("");
        String[] s = str.split(" ");
        if (pattern.length() != s.length) return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char c = pattern.charAt(i);
            if (!map1.containsKey(c)) map1.put(c, s[i]);
            else if (!s[i].equals(map1.get(c))) return false;
            if (!map2.containsKey(s[i])) map2.put(s[i], c);
            else if (c != map2.get(s[i])) return false;
        }
        return true;
    }
}