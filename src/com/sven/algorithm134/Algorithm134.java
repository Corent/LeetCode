package com.sven.algorithm134;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/4
 */
public class Algorithm134 {
}

/**
 * https://www.cnblogs.com/felixfang/p/3814463.html
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if (gas == null || cost == null || gas.length != cost.length) return -1;
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else sum += gas[i] - cost[i];
        }
        return total < 0? -1: start;
    }
}