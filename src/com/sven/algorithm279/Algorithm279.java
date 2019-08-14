package com.sven.algorithm279;

import java.util.Arrays;

public class Algorithm279 {

    public static void main(String[] args) {
        System.out.println(new Solution3().numSquares(12));
    }
}

/**
 * 贪心算法 + 递归回溯，效率不高
 */
class Solution {

    private int ans = Integer.MAX_VALUE;

    public int numSquares(int n) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        numSquares(n, 0);

        return ans;
    }

    private void numSquares(int n, int cnt) {
        if (n == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (cnt >= ans) return;

        int m = Double.valueOf(Math.sqrt(n)).intValue();
        for (int i = m; i > 0; i--) {
            numSquares(n - i * i, cnt + 1);
        }
    }
}

/**
 * https://blog.csdn.net/qq_17550379/article/details/80875782
 * Lagrange 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和
 */
class Solution2 {

}

/**
 * dp[i]表示以i为和的最少平方的和的个数
 */
class Solution3 {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j * j < i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}