package com.sven.algorithm756;

import java.util.*;

public class Algorithm756 {
}

class Solution {

    private boolean ans = false;
    private Map<String, Set<Character>> allowedMap = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom == null || bottom.length() == 0
        || (bottom.length() > 1 && (allowed == null || allowed.size() == 0))) return false;
        if (bottom.length() == 1) return true;
        for (String s: allowed) {
            String key = s.substring(0, 2);
            allowedMap.putIfAbsent(key, new HashSet<>());
            allowedMap.get(key).add(s.charAt(2));
        }
        pyramidTransition(bottom.toCharArray());
        return ans;
    }

    private void pyramidTransition(char[] chs) {
        if (ans) return;
        if (chs.length == 1) {
            ans = true;
            return;
        }
        List<Set<Character>> sets = new ArrayList<>();
        for (int i = 1; i < chs.length; i++) {
            String key = "" + chs[i - 1] + chs[i];
            if (!allowedMap.containsKey(key)) return;
            sets.add(allowedMap.get(key));
        }
        pyramidTransition(0, new char[chs.length - 1], sets);
    }

    private void pyramidTransition(int idx, char[] chs, List<Set<Character>> sets) {
        if (idx == sets.size()) {
            pyramidTransition(chs);
            return;
        }
        for (char ch: sets.get(idx)) {
            chs[idx] = ch;
            pyramidTransition(idx + 1, chs, sets);
        }
    }
}