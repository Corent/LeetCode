package com.sven.algorithm069;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 10/03/2018
 */
public class Algorithm069 {
}

/**
 * 二分查找，注意溢出
 */
class Solution {

    public int mySqrt(int x) {
        long s = 1, e = x;
        while (s + 1 < e) {
            long m = (s + e) / 2;
            long m2 = m * m;
            if (m2 > x) e = m;
            else if (m2 < x) s = m;
            else return (int) m;
        }
        return (int) (e * e > x? s: e);
    }
}