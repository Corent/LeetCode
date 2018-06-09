package com.sven.algorithm202;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm202 {
}

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int next = 0;
            while (n > 0) {
                int m = n % 10;
                n /= 10;
                next += m * m;
            }
            n = next;
            if (set.contains(n)) break;
            set.add(n);
        }
        return n == 1;
    }
}