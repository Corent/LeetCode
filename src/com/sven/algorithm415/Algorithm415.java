package com.sven.algorithm415;

public class Algorithm415 {

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("0", "0"));
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        char[] chs = new char[Math.max(num1.length(), num2.length())];
        int idx = chs.length - 1, carrier = 0;
        while (idx >= 0) {
            int idx1 = num1.length() - 1 - (chs.length - 1 - idx);
            int idx2 = num2.length() - 1 - (chs.length - 1 - idx);
            int n1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int n2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int n = n1 + n2 + carrier;
            carrier = n / 10;
            n %= 10;
            chs[idx--] = (char) (n + '0');
        }
        StringBuilder builder = new StringBuilder();
        builder.append(chs);
        return carrier > 0 ? carrier + builder.toString() : builder.toString();
    }
}