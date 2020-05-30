package com.sven.algorithm600;

public class Algorithm600 {
}

/**
 * http://www.mamicode.com/info-detail-2614808.html
 */
class Solution {

    public int findIntegers(int num) {
        if (num == 0) return 1;
        String binary = Integer.toBinaryString(num);
        int len = binary.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 2;
        //计算场i的二进制位符合要求的个数
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //计算0~n的符合要求的总个数
        int sum = 0;
        for (int i = 0, k = len; i < len; i++, k--) {
            if (binary.charAt(i) == '1') {
                sum += dp[k - 1];
                if (i > 0 && binary.charAt(i - 1) == '1') {
                    return sum;
                }
            }
        }
        //先前没有return，到这里，说明n本身没有算进去
        sum++;
        return sum;
    }
}