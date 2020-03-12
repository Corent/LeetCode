package com.sven.algorithm120;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/28
 */
public class Algorithm120 {
}

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int rowCnt = row.size();
            for (int j = rowCnt - 1; j >= 0; j--) {
                if (j == 0) dp[j] = dp[j] + row.get(j);
                else if (j == rowCnt - 1) dp[j] = dp[j - 1] + row.get(j);
                else dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}