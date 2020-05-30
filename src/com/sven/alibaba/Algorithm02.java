package com.sven.alibaba;

import java.util.HashMap;
import java.util.Map;

public class Algorithm02 {
}

class Solution2 {

    public static void main(String[] args) {

    }

    public boolean func(String pattern, String str) {
        if (pattern == null) return false;
        if (pattern.length() == 0) return str != null && str.trim().length() == 0;

        char[] chs = pattern.toCharArray();
        String[] strs = str.trim().split(" ");

        if (chs.length != strs.length) return false;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if (!map1.containsKey(chs[i]) && !map2.containsKey(strs[i])) {
                map1.put(chs[i], strs[i]);
                map2.put(strs[i], chs[i]);
                continue;
            }

            if (map1.containsKey(chs[i]) && !map2.containsKey(strs[i]) ||
                    !map1.containsKey(chs[i]) && map2.containsKey(strs[i])) {
                return false;
            }

            String s = map1.get(chs[i]);
            char c = map2.get(strs[i]);
            if (!s.equals(strs[i]) || c != chs[i]) return false;
        }
        return true;
    }
}