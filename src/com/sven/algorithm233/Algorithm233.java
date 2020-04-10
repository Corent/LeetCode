package com.sven.algorithm233;

public class Algorithm233 {
}

/**
 * https://www.cnblogs.com/grandyang/p/4629032.html
 *
 * 剑指Offer 面试题32
 */
class Solution {
    public int countDigitOne(int n) {
        int ans = 0, a = 1, b = 1;
        while (n > 0) {
            ans += (n + 8) / 10 * a + (n % 10 == 1? 1 : 0) * b;
            b += n % 10 * a;
            a *= 10;
            n /= 10;
        }
        return ans;
    }
}

/**
 * 看每一位是1各有多少种排列组合
 * https://www.bilibili.com/video/BV1uJ411573j
 */
class Solution2 {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int cnt = 0, m = String.valueOf(n).length();
        for (int i = 1; i <= m; i++) {
            int pow10 = Double.valueOf(Math.pow(10, i - 1)).intValue();
            int high = (n / pow10) / 10;
            cnt += high * pow10;

            int digit = (n / pow10) % 10;
            if (digit > 1) cnt += pow10;
            else if (digit == 1) cnt += n % pow10 + 1;
        }
        return cnt;
    }
}