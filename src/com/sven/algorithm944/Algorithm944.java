package com.sven.algorithm944;

public class Algorithm944 {
}

class Solution {

    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) return 0;
        int ans = 0, m = A.length, n = A[0].length();
        for (int j = 0; j < n; j++) {
            char pre = A[0].charAt(j);
            for (int i = 1; i < m; i++) {
                char ch = A[i].charAt(j);
                if (ch >= pre) {
                    pre = ch;
                    continue;
                }
                ans++;
                break;
            }
        }
        return ans;
    }
}