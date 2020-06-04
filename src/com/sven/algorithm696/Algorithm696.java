package com.sven.algorithm696;

import java.util.ArrayList;
import java.util.List;

public class Algorithm696 {
}

class Solution {

    public int countBinarySubstrings(String s) {
        List<Integer> groups = new ArrayList<>();
        int n = 1;
        char m = s.charAt(0);
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length()) {
                groups.add(n);
                break;
            }
            char ch = s.charAt(i);
            if (ch == m) n++;
            else {
                groups.add(n);
                n = 1;
                m = ch;
            }
        }
        int cnt = 0;
        for (int i = 1; i < groups.size(); i++) {
            cnt += Math.min(groups.get(i - 1), groups.get(i));
        }
        return cnt;
    }
}