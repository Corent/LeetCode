package com.sven.algorithm446;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm446 {
}

/**
 * cnt = maps[i].get(diff) 表示以A[i]结尾的等差diff序列长度
 * https://www.cnblogs.com/f91og/p/9721507.html
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, ans = 0;
        Map<Integer, Integer>[] maps = new HashMap[n];

        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diffLong = Long.valueOf(A[i]) - A[j];
                if (diffLong > Integer.MAX_VALUE || diffLong < Integer.MIN_VALUE) {
                    continue;
                }

                int diff = Long.valueOf(diffLong).intValue();
                int count = maps[j].getOrDefault(diff, 0);
                ans += count;   // 只要有diff存在，之前至少有两个点，再加上A[i]就变成三个，满足条件
                //  获取maps[j]的值后，再计算maps[i]的值，更新为 原本的值 + 连上j新增的值 + 1
                int original = maps[i].getOrDefault(diff, 0);
                maps[i].put(diff, original + count + 1);
            }
        }

        return ans;
    }
}

/**
 * dp
 * https://www.bilibili.com/video/BV18441147an?from=search&seid=13593822261191530962
 */
class Solution2 {

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length, ans = 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>(); // 用于保存值与id的映射关系
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(Long.valueOf(A[i]), new ArrayList<>());
            map.get(Long.valueOf(A[i])).add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {   // A[i] - A[j] = A[j] - A[k]
                long target = 2 * Long.valueOf(A[j]) - A[i];    //  A[k] = 2 * A[j] - A[i]
                if (map.containsKey(target)) {
                    for (int k: map.get(target)) {
                        if (k < j) {
                            dp[i][j] += (dp[j][k] + 1);
                        }
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}