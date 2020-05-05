package com.sven.algorithm458;

public class Algorithm458 {
}

/**
 * https://zhuanlan.zhihu.com/p/74663700
 */
class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        double tmp = Math.log(buckets) / Math.log(base);
        return Double.valueOf(Math.ceil(tmp)).intValue();
    }
}