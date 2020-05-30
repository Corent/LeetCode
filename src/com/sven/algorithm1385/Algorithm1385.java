package com.sven.algorithm1385;

public class Algorithm1385 {
}

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int m: arr1) {
            int idx = 0;
            while (idx < arr2.length && Math.abs(m - arr2[idx++]) > d);
            if (idx == arr2.length) ans++;
        }
        return ans;
    }
}