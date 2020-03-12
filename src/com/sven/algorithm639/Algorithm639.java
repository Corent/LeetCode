package com.sven.algorithm639;

public class Algorithm639 {
}

/**
 * https://blog.csdn.net/tzyshiwolaogongya/article/details/81290033
 * Algorithm91 Decode Ways
 */
class Solution {

    public int numDecodings(String s) {
        int p = 1000000007;
        long f1 = 1, f2 = helper(s.substring(0, 1)) % p;
        for (int i = 1; i < s.length(); i++) {
            long f3 = (f2 * helper(s.substring(i, i + 1))) + (f1 * helper(s.substring(i - 1, i + 1)));
            f1 = f2;
            f2 = f3 % p;
        }
        return Long.valueOf(f2).intValue();
    }

    private int helper(String s) {
        if (s.length() == 1) {
            if (s.equals("*")) return 9;
            return s.equals("0") ? 0 : 1;
        }
        if (s.equals("**")) return 15; // 11-26, except 20 because '*' is 1-9
        else if (s.charAt(1) == '*') {
            if (s.charAt(0) == '1') return 9;
            return s.charAt(0) == '2' ? 6 : 0;
        } else if (s.charAt(0) == '*') return s.charAt(1) <= '6' ? 2 : 1;
        else {
            int n = Integer.valueOf(s);
            return  n >= 10 && n <= 26 ? 1 : 0;
        }
    }
}