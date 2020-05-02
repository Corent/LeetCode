package com.sven.algorithm413;

public class Algorithm413 {
}

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int ans = 0;
        for (int i = 0; i < A.length - 1; ) {
            int diff = A[i + 1] - A[i], j = i + 2;
            while (j < A.length && A[j] - A[j - 1] == diff) j++;
            int n = j - i;
            if (n > 2){
                ans += (n - 1) * (n - 2) / 2;
                i = j;
            } else i++;
        }
        return ans;
    }
}