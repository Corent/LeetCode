package com.sven.algorithm003;

import java.util.Arrays;

public class Algorithm003 {

    public static void main(String[] args) {

    }
}

/**
 * lastPos数组存储对应的字符上一次出现的位置
 * left是上一次出现重复字符的位置
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int[] lastPos = new int[256];
        Arrays.fill(lastPos, -1);
        int maxLen = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, lastPos[s.charAt(i)]);
            lastPos[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, i - left);
        }
        return maxLen;
    }
}