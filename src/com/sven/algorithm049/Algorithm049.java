package com.sven.algorithm049;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm049 {

    public static void main(String[] args) {}
}

/**
 * 效率低
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

    private String getKey(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}

class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> getKey(s), Collectors.toList())).values());
    }

    private String getKey(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
}