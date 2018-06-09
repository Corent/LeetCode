package com.sven.algorithm204;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/9
 */
public class Algorithm204 {
}

/**
 * https://blog.csdn.net/lisonglisonglisong/article/details/45309651
 */
class Solution {
    public int countPrimes(int n) {

        int ans = 0;
        if (n < 3) return ans;

        boolean[] del = new boolean[n];
        del[0] = true;
        del[1] = true;
        del[2] = false;

        for (int i = 2; i < n; i++) {
             if (del[i]) continue;
             if (i * i > n) break;
             for (int j = 2; i * j < n; j++) {
                 del[i * j] = true;
             }
        }

        for (Boolean b: del)
            if (!b) ans++;

        return ans;
    }
}