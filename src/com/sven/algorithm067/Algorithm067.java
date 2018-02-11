package com.sven.algorithm067;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 10/02/2018
 */
public class Algorithm067 {

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        int m = a.length(), n = b.length();
        String ans = "";
        int i = m - 1, j = n - 1, carrier = 0;
        while (i >= 0 || j >= 0) {
            int sum = (i >= 0? a.charAt(i--) - '0': 0) + (j >= 0? b.charAt(j--) - '0': 0) + carrier;
            ans = sum % 2 + ans;
            carrier = sum / 2;
        }
        return carrier == 0? ans: carrier + ans;
    }
}