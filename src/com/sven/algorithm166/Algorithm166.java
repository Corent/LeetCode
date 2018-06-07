package com.sven.algorithm166;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm166 {

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(-2147483648, 1));
    }
}

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";

        String ans = null;
        StringBuilder builder = new StringBuilder();
        boolean isNegative = (numerator < 0) ^ (denominator < 0);

        long num = Math.abs(Long.valueOf(numerator)), den = Math.abs(Long.valueOf(denominator));
        long res = num / den, rem = (num % den) * 10;
        builder.append(res);
        if (rem == 0) {
            ans = builder.toString();
            return isNegative? "-" + ans: ans;
        }

        //存储循环节开始位置
        Map<Long, Integer> map = new HashMap<>();
        builder.append(".");
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int beg = map.get(rem);
                String tmp = builder.toString();
                String part1 = tmp.substring(0, beg);
                String part2 = tmp.substring(beg);
                builder = new StringBuilder();
                ans = builder.append(part1).append("(").append(part2).append(")").toString();
                return isNegative? "-" + ans: ans;
            }

            map.put(rem, builder.length());
            res = rem / den;
            builder.append(res);
            rem = (rem % den) * 10;
        }

        ans = builder.toString();
        return isNegative? "-" + ans: ans;
    }
}