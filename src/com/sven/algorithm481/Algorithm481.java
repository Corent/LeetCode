package com.sven.algorithm481;

public class Algorithm481 {
}

class Solution {

    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n >= 1 && n <= 3) return 1;
        int count = 1, num = 1, head = 2, tail = 3;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = dp[2] = 2;
        while (tail < n) {
            for (int i = 0; i < dp[head]; i++) {
                dp[tail] = num;
                if (tail++ < n && num == 1) count++;
            }
            num = num ^ 3;  //  1 ^ 3 = 2，2 ^ 3 = 1
            head++;
        }
        return count;
    }
}