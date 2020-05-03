package com.sven.algorithm438;

import java.util.ArrayList;
import java.util.List;

public class Algorithm438 {

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[26];
        int m = s.length(), n = p.length();
        for (int i = 0; i < n; i++) hash[p.charAt(i) - 'a']++;
        int i = 0, j = 0;
        while (j < m) {
            char ch = s.charAt(j);
            hash[ch - 'a']--;
            while (i <= j && hash[ch - 'a'] < 0) hash[s.charAt(i++) - 'a']++;
            if (j - i + 1 == n) {
                ans.add(i);
            }
            j++;
        }
        return ans;
    }
}