package com.sven.algorithm343;

public class Algorithm343 {
}

/**
 * https://www.cnblogs.com/zywscq/p/5415303.html
 */

class Solution1 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <= n; i++){
            dp[i] = -1;
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(j * dp[i - j], Math.max(dp[i], j * (i - j)));
            }
        }
        return dp[n];
    }
}

class Solution2 {
    public int integerBreak(int n) {
        switch (n) {
            case 1: case 2:
                return 1;
            case 3:
                return 2;
            default:
                int m = n % 3;
                switch (m) {
                    case 0:
                        return Double.valueOf(Math.pow(3, n / 3)).intValue();
                    case 1:
                        return 2 * 2 * Double.valueOf(Math.pow(3, (n - 4) / 3)).intValue();
                    default:
                        return 2 * Double.valueOf(Math.pow(3, n/3)).intValue();
                }
        }
    }
}