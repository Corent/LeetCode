package com.sven.algorithm171;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm171 {
}

class Solution {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int ans = 0, tmp = 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            ans += (chs[i] - 'A' + 1) * tmp;
            tmp *= 26;
        }
        return ans;
    }
}