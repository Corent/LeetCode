package com.sven.algorithm1234;

public class Algorithm1234 {
}

/**
 * 参考Algorithm 76
 */
class Solution {

    private int idx(char ch) {
        switch (ch) {
            case 'Q': return 0;
            case 'W': return 1;
            case 'E': return 2;
            case 'R': return 3;
            default: break;
        }
        return -1;
    }

    private int findMinWin(int[] hash, int cnt, String s) {
        int ansLen = Integer.MAX_VALUE, tLen = cnt, tInWinCnt = 0;
        char[] chs = s.toCharArray();
        for (int winStart = 0, winEnd = 0; winEnd < s.length(); winEnd++) {
            char endCh = chs[winEnd];
            if (hash[idx(endCh)] > 0) tInWinCnt++;
            hash[idx(endCh)]--;
            while (tInWinCnt >= tLen) {
                int winLen = winEnd - winStart + 1;
                if (ansLen > winLen) {
                    ansLen = winLen;
                }
                char startCh = chs[winStart];
                hash[idx(startCh)]++;
                if (hash[idx(startCh)] > 0) tInWinCnt--;
                winStart++;
            }
        }
        return ansLen;
    }

    public int balancedString(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), cnt = 0;
        int[] hash = new int[4];
        for (int i = 0; i < n; i++) {
            hash[idx(s.charAt(i))]++;
        }

        for (int i = 0; i < 4; i++) {
            if (hash[i] > n / 4) {
                cnt += (hash[i] -= n / 4);
            } else hash[i] = 0;
        }

        if (cnt == 0) return 0;

        return findMinWin(hash, cnt, s);
    }
}

/**
 * https://blog.csdn.net/dezhonger/article/details/103555700
 */
class Solution2 {

    private int avg;
    private int[] sHash = new int[4];
    private int[] wHash = new int[4];

    private int idx(char ch) {
        switch (ch) {
            case 'Q': return 0;
            case 'W': return 1;
            case 'E': return 2;
            case 'R': return 3;
            default: break;
        }
        return -1;
    }

    public int balancedString(String s) {
        for (char c : s.toCharArray()) sHash[idx(c)]++;
        if (sHash[0] == sHash[1] && sHash[1] == sHash[2] && sHash[2] == sHash[3]) return 0;
        avg = s.length() / 4;
        int left = 0, right = 0, ans = s.length();
        for (; right < s.length(); right++) {
            wHash[idx(s.charAt(right))]++;
            if (!check()) continue;
            ans = Math.min(ans, right - left + 1);
            while (left <= right) {
                wHash[idx(s.charAt(left++))]--;
                if (check()) {
                    ans = Math.min(ans, right - left + 1);
                } else break;
            }
        }
        return ans;
    }

    private boolean check() {   //  检查窗口外的字符数量是否都小于length/4
        for (int i = 0; i < 4; i++) {
            if (sHash[i] - wHash[i] > avg) {
                return false;
            }
        }
        return true;
    }
}