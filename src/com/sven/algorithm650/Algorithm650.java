package com.sven.algorithm650;

public class Algorithm650 {
}

/**
 * dp[i]表示达到 i 所需的最少操作次数
 * 最后一次操作一定是paste，而且粘贴的数量一定是小于 i 的因子
 * j 是 i 的最大因子的话，dp[i] = dp[j] + 1 + (i / j) - 1 = dp[j] + i / j
 */
class Solution {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];  //  初始 dp[1] = 0
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 2, j = i / k; j >= 1; j = i / ++k) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}

/**
 * DFS
 * 这TM竟然能过！！！
 */
class Solution2 {

    private int n;
    private int ans = Integer.MAX_VALUE;

    public int minSteps(int n) {
        this.n = n;
        minSteps(1, null, 0, false);
        return ans;
    }

    private void minSteps(int m, Integer preCopied, int step, boolean lastStepIsCopy) {
        if (m == n) {
            ans = Math.min(ans, step);
            return;
        }
        if (m > n) return;
        if (preCopied != null && preCopied + m > n) return;
        if (!lastStepIsCopy) {
            minSteps(m, m, step + 1, true);
        }
        if (preCopied != null) {
            minSteps(m + preCopied, preCopied, step + 1, false);
        }
    }
}

/**
 * 以上两种解法都是寄几想出来的，这是第一种解法的优化
 * https://www.cnblogs.com/syjbupt/p/7440824.html
 */
class Solution3 {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];  //  初始 dp[1] = 0
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int k = 2, j = i / k; j >= 1; j = i / ++k) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    break;
                }
            }
        }
        return dp[n];
    }
}