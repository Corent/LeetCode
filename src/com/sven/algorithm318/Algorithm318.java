package com.sven.algorithm318;

import java.util.HashSet;
import java.util.Set;

public class Algorithm318 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}

/**
 * 暴力法，用屁股想想都知道会超时
 * .....
 * 然而竟然过了
 */
class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        if (words == null || words.length < 2) return ans;
        int[] letters = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] chs = words[i].toCharArray();
            for (char ch: chs) {
                int bit = 1 << (ch - 'a');
                if ((letters[i] & bit) != 0) continue;
                letters[i] += bit;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((letters[i] & letters[j]) != 0) continue;
                ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }

        return ans;
    }
}