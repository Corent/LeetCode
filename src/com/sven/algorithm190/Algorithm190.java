package com.sven.algorithm190;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm190 {
}

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans |= ((n >> i) & 1) << (31 - i);
        }
        return ans;
    }
}