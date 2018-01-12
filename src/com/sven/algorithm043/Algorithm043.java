package com.sven.algorithm043;

import java.util.Arrays;

public class Algorithm043 {
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() < 1 || num1.equals("0") ||
                num2 == null || num2.length() < 1 || num2.equals("0"))
            return "0";
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        Arrays.fill(res, 0);
        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++)
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        String ans = "";
        for (int k = len1 + len2 - 1; k >= 0; k--) {
            if (k > 0) res[k - 1] += res[k] / 10;
            res[k] %= 10;
            ans = ((char) (res[k] + '0')) + ans;
        }
        return ans.charAt(0) == '0'? ans.substring(1): ans;
    }
}