package com.sven.algorithm049;

import java.util.*;

public class Algorithm049 {

    public static void main(String[] args) {
        System.out.println(new Solution().getKey("abc"));
    }
}

/**
 * 太简单就不解释了，这种方法效率低
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String key = getKey(s);
            List<String> list = map.get(key);
            if (list == null) list = new ArrayList<>();
            list.add(s);
            map.put(key, list);
        }
        for (String key: map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    public String getKey(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}