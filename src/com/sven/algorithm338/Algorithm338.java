package com.sven.algorithm338;

public class Algorithm338 {
}

/**
 * O(n*sizeof(integer)) 解法EZ
 *
 * O(n) 解法 https://blog.csdn.net/westbrook1998/article/details/80152822
 */
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}