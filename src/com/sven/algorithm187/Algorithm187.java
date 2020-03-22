package com.sven.algorithm187;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm187 {
}

/**
 * 用两位bit标记各个字母，20个bit作为substring的key
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Character, Integer> vals = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};

        int key = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            key = ((key << 2) | vals.get(s.charAt(i))) & 0x000fffff;
            if (i < 9) continue;
            if (!map.containsKey(key)) {
                map.put(key, 1);
                continue;
            }
            map.put(key, map.get(key) + 1);
            String str = s.substring(i - 9, i + 1);
            if (!set.contains(str)) {
                ans.add(str);
                set.add(str);
            }
        }
        return ans;
    }
}