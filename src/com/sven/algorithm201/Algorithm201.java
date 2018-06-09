package com.sven.algorithm201;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm201 {
}

/**
 * https://www.cnblogs.com/grandyang/p/4431646.html
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) n &= (n - 1);
        return n;
    }
}