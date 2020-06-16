package com.sven.algorithm754;

import java.util.*;

public class Algorithm754 {
}

/**
 * https://blog.csdn.net/weixin_37373020/article/details/80963488
 */
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, idx = 0;
        while (sum < target) sum += ++idx;
        if (sum == target) return idx;
        return ((sum - target) & 1) == 0 ? idx : ((idx & 1) == 0) ? idx + 1 : idx + 2;
    }
}

/**
 * Time Limit Exceeded
 */
class Solution2 {

    public int reachNumber(int target) {
        Set<Integer>[] sets = new HashSet[] { new HashSet<Integer>(), new HashSet<Integer>() };
        int idx = 0;
        sets[idx & 1].add(0);
        while (!sets[idx & 1].contains(target)) {
            sets[(idx + 1) & 1].clear();
            for (Integer i: sets[idx & 1]) {
                sets[(idx + 1) & 1].add(i + idx + 1);
                sets[(idx + 1) & 1].add(i - idx - 1);
            }
            idx++;
        }
        return idx;
    }
}