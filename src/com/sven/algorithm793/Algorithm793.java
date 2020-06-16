package com.sven.algorithm793;

public class Algorithm793 {
}

/**
 * https://www.cnblogs.com/Marcusyang/p/12997511.html
 */
class Solution {
    public int preimageSizeFZF(int K) {
        int last = 1;
        while (last < K) last = 5 * last + 1;
        while (last > 1) {
            if (last - 1 == K) return 0;
            last = (last - 1) / 5;
            K %= last;
        }
        return 5;
    }
}