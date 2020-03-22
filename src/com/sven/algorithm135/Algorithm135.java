package com.sven.algorithm135;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/4
 */
public class Algorithm135 {
}

class Solution {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length, ans = 0;
        int[] candies = new int[n];

        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            candies[i] = ratings[i] > ratings[i - 1]? candies[i - 1] + 1: 1;
        }
        ans += candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            ans += candies[i];
        }

        return ans;
    }
}