package com.sven.algorithm070;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 27/04/2018
 */
public class Algorithm070 {
}

class Solution {
    public int climbStairs(int n) {
        if (n < 4) return n;
        int m1 = 3, m2 = 5;
        for (int i = 4; i < n; i++) {
            int tmp = m2;
            m2 += m1;
            m1 = tmp;
        }
        return m2;
    }
}