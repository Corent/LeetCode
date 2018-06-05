package com.sven.algorithm139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/5
 */
public class Algorithm139 {
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] m = new boolean[n][n];  //标记子串s[i:j]是否存在于wordDict
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                m[i][j] = wordSet.contains(s.substring(i, j + 1));
            }
        }

        boolean[] dp = new boolean[n];  //dp[j]表示s[0:j]字符串是否可以由wordDict中的单词组成
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
}