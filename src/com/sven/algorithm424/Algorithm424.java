package com.sven.algorithm424;

public class Algorithm424 {
}

/**
 * https://blog.csdn.net/wwxy1995/article/details/90722606
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int ans = 0, maxCnt = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            hash[s.charAt(j) - 'A']++;
            maxCnt = Math.max(maxCnt, hash[s.charAt(j) - 'A']);
            while (j - i + 1 - maxCnt > k) hash[s.charAt(i++) - 'A']--;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}