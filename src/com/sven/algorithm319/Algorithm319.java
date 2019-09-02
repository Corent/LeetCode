package com.sven.algorithm319;

public class Algorithm319 {
}

/**
 * 求完全平方数的个数
 */
class Solution {
    public int bulbSwitch(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int ii = Double.valueOf(Math.sqrt(i)).intValue();
            if (ii * ii == i) ans++;
        }
        return ans;
    }
}