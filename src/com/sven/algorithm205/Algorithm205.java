package com.sven.algorithm205;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/9
 */
public class Algorithm205 {
}

/**
 * https://www.cnblogs.com/grandyang/p/4465779.html
 *
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {

        int n = s.length();
        int[] sHash = new int[256], tHash = new int[256];
        for (int i = 0; i < n; i++) {
            if (sHash[s.charAt(i)] != tHash[t.charAt(i)]) return false;
            sHash[s.charAt(i)] = tHash[t.charAt(i)] = i + 1;
            //hash表记录对应字符串相应位置的字符，映射到另一个字符串中的位置+1
        }
        return true;
    }
}