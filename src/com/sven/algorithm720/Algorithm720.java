package com.sven.algorithm720;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Algorithm720 {

    public static void main(String[] args) {

    }
}

class Solution {

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";
        int maxLen = 0, idx = 0;
        Arrays.sort(words);
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) wordMap.put(words[i], i);
        int[] dp = new int[words.length];
        boolean[] start = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            start[i] = false;
            if (words[i].length() > 1) {
                String preWord = words[i].substring(0, words[i].length() - 1);
                if (wordMap.containsKey(preWord)) {
                    int preIdx = wordMap.get(preWord);
                    dp[i] = dp[preIdx] + 1;
                    start[i] = start[preIdx];
                }
            } else start[i] = true;
            if (dp[i] > maxLen && start[i]) {
                maxLen = dp[i];
                idx = i;
            }
        }
        return words[idx];
    }
}