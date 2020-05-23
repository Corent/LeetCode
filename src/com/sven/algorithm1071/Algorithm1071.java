package com.sven.algorithm1071;

import java.util.ArrayList;
import java.util.List;

public class Algorithm1071 {
}

class Solution {

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) return "";
        int m = str1.length(), n = str2.length();
        if (m == 0 || n == 0) return "";

        for (int i = Math.min(m, n), j = 1; i > 0; i = Math.min(m, n) / j++) {
            if (m % i == 0 && n % i == 0) {
                String s = str1.substring(0, i);
                if (str1.matches("^(" + s + ")+$") && str2.matches("^(" + s + ")+$")) {
                    return s;
                }
            }
        }
        return "";
    }
}