package com.sven.algorithm172;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm172 {
}

class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n /= 5);
        }
        return ans;
    }
}