package com.sven.algorithm354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Algorithm354 {
}

/**
 * 自定义排序 + 最长递增子序列
 * MaxLen[0] = 1，MaxLen[i] = max{  A[i] >=A [k]? (MaxLen[k] + 1): 1 }，k = 0, 1, 2, ..., i-1
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) return 0;
        List<int[]> envelopeList = new ArrayList<>();
        Arrays.stream(envelopes).forEach(e -> envelopeList.add(new int[] {e[0], e[1]}));
        Collections.sort(envelopeList, (o1, o2) -> o1[0] != o2[0]? o1[0] - o2[0]: o1[1] - o2[1]);

        int ans = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int idx = 1; idx < dp.length; idx++) {
            int[] m = envelopeList.get(idx);
            for (int k = idx - 1; k >= 0; k--) {
                int[] n = envelopeList.get(k);
                if (n[0] < m[0] && n[1] < m[1]) {
                    dp[idx] = Math.max(dp[idx], dp[k] + 1);
                }
            }
            ans = Math.max(ans, dp[idx]);
        }

        return ans;
    }
}