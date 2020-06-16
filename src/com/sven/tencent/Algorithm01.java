package com.sven.tencent;

public class Algorithm01 {

    public static void main(String[] args) {
        System.out.println(new Solution().addStrs("923", "3456"));
    }

    static class Solution {

        public String addStrs(String s1, String s2) {
            if (s1 == null || s1.length() == 0) return s2;
            if (s2 == null || s2.length() == 0) return s1;
            int m = s1.length(), n = s2.length(), carrier = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= Math.max(m, n); i++) {
                int a = i > m ? 0 : s1.charAt(m - i) - '0';
                int b = i > n ? 0 : s2.charAt(n - i) - '0';
                int sum = a + b + carrier;
                builder.append(sum % 10);
                carrier = sum / 10;
            }
            return carrier == 0 ? builder.reverse().toString() : carrier + builder.reverse().toString();
        }
    }
}