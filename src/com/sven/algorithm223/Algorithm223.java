package com.sven.algorithm223;

public class Algorithm223 {
}

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ans = Math.abs(A - C) * Math.abs(B - D) + Math.abs(E - G) * Math.abs(F - H);
        if (!(B > H || D < F) && !(C < E || A > G)) {
            int h = Math.min(D, H) - Math.max(B, F);
            int w = Math.min(C, G) - Math.max(A, E);
            ans -= h * w;
        }
        return ans;
    }
}