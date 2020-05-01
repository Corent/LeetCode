package com.sven.algorithm396;

public class Algorithm396 {
}

/**
 * F(i) = F(i-1) + sum - A.size() * A[A.size() - i]
 * https://blog.csdn.net/weixin_35338624/article/details/90524056
 */
class Solution {
    public int maxRotateFunction(int[] A) {
        int f = 0, sum = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            f += i * A[i];
        }
        int ans = f;
        for (int i = 0; i < n; i++) {
            f = f + sum - n * A[n - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}