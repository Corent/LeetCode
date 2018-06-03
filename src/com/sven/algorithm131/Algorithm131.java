package com.sven.algorithm131;

import java.util.ArrayList;
import java.util.List;

public class Algorithm131 {
}

class Solution {

    private String s;
    private Integer n;
    private List<String> current = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();

    private boolean isPalindrome(int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) return false;
            from++;
            to--;
        }
        return true;
    }

    private void partitionCore(int from) {
        if (from == n) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int to = from; to < n; to++) {
            if (isPalindrome(from, to)) {
                current.add(s.substring(from, to + 1));
                partitionCore(to + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        if (s == null) return ans;
        n = s.length();
        if (n == 0) return ans;
        this.s = s;
        partitionCore(0);
        return ans;
    }
}