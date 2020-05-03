package com.sven.algorithm451;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Algorithm451 {
}

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() < 2) return s;
        int[] hash = new int[256];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) hash[s.charAt(i)]++;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) continue;
            list.add(new int[] { i, hash[i] });
        }
        list.sort((o1, o2) -> o2[1] - o1[1]);
        StringBuilder builder = new StringBuilder();
        for (int[] pair: list) {
            while (pair[1]-- > 0) builder.append((char) pair[0]);
        }
        return builder.toString();
    }
}