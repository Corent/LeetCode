package com.sven.algorithm076;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 09/05/2018
 */
public class Algorithm076 {
}

class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        int[] tHash = new int[256];
        char[] chs = s.toCharArray();
        int ansLen = Integer.MAX_VALUE, tLen = t.length(), tInWinCnt = 0;
        for (char c: t.toCharArray()) tHash[c]++;
        for (int winStart = 0, winEnd = 0; winEnd < s.length(); winEnd++) {
            char endCh = chs[winEnd];
            if (tHash[endCh] > 0) tInWinCnt++;
            tHash[endCh]--;
            while (tInWinCnt >= tLen) {
                int winLen = winEnd - winStart + 1;
                if (ansLen > winLen) {
                    ansLen = winLen;
                    ans = s.substring(winStart, winEnd + 1);
                }
                char startCh = chs[winStart];
                tHash[startCh]++;
                if (tHash[startCh] > 0) tInWinCnt--;
                winStart++;
            }
        }
        return ans;
    }
}