package com.sven.algorithm066;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 10/02/2018
 */
public class Algorithm066 {
}

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int[] ans = null;
        int carrier = 1, n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carrier;
            digits[i] = sum % 10;
            carrier = sum / 10;
        }
        if (carrier == 0) ans = digits;
        else {
            ans = new int[n + 1];
            System.arraycopy(digits, 0, ans, 1, n);
            ans[0] = carrier;
        }
        return ans;
    }
}