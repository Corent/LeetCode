package com.sven.algorithm164;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm164 {
}

/**
 * 桶排序，比较相邻两桶的最大最小值
 */
class Solution {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int max = nums[0], min = nums[0];
        for (int n: nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int len = (max - min) / nums.length + 1;
        Bucket[] buckets = new Bucket[(max - min) / len + 1];
        for (int n: nums) {
            int i = (n - min) / len;
            if (buckets[i] == null) {
                buckets[i] = new Bucket(n, n);
            } else {
                if (n < buckets[i].min) buckets[i].min = n;
                if (n > buckets[i].max) buckets[i].max = n;
            }
        }

        int gap = 0, prev = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            gap = Math.max(gap, buckets[i].min - buckets[prev].max);
            prev = i;
        }
        return gap;
    }

    class Bucket {
        public Integer min;
        public Integer max;

        public Bucket(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}