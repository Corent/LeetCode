package com.sven.algorithm140;

import java.util.*;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm140 {

    public static void main(String[] args) {
        List<String> ans = new Solution().wordBreak("catsanddog", Arrays.asList(new String[] {"cat","cats","and","sand","dog"}));
        ans.forEach(System.out::println);
    }
}

class Solution {

    private int n;
    private String s;
    private boolean[] dp;
    private boolean[][] m;
    private Set<String> wordSet;

    private List<String> words = new ArrayList<>();
    private List<String> ans = new ArrayList<>();

    private boolean wordBreakI(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        this.m = new boolean[n][n];  //标记子串s[i:j]是否存在于wordDict
        this.wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                m[i][j] = wordSet.contains(s.substring(i, j + 1));
            }
        }

        this.dp = new boolean[n];  //dp[j]表示s[0:j]字符串是否可以由wordDict中的单词组成
        for (int j = 0; j < n; j++) {
            if (j == 0) dp[j] = m[0][0];
            else {
                if (m[0][j]) dp[j] = true;
                else {
                    dp[j] = false;
                    for (int i = 0; i < j; i++) {
                        if (dp[i] && m[i + 1][j]) {
                            dp[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[n - 1];
    }

    private void wordBreakCore(int from) {
        if (from == n) {
            StringBuilder builder = new StringBuilder();
            int size = words.size();
            for (int i = 0; i < size; i++) {
                builder.append(words.get(i));
                if (i != size - 1) builder.append(" ");
            }
            ans.add(builder.toString());
            return;
        }

        if (from > 0 && !dp[from - 1]) return;
        int len = n - from;
        for (int i = 0; i < len; i++) {
            if (m[from][from + i]) {
                words.add(s.substring(from, from + i + 1));
                wordBreakCore(from + i + 1);
                words.remove(words.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (!wordBreakI(s, wordDict)) return ans;
        wordBreakCore(0);
        return ans;
    }
}