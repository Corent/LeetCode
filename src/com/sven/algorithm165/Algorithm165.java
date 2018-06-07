package com.sven.algorithm165;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/7
 */
public class Algorithm165 {
}

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\."), nums2 = version2.split("\\.");
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        while (i < n && j < m) {
            int tmp1 = Integer.valueOf(nums1[i]);
            int tmp2 = Integer.valueOf(nums2[j]);
            if (tmp1 == tmp2) {
                i++;
                j++;
            } else return tmp1 > tmp2? 1: -1;
        }

        if (i < n && j == m) {
            for (; i < n; i++) {
                if (Integer.valueOf(nums1[i]) != 0)
                    return 1;
            }
            return 0;
        }
        if (i == n && j < m) {
            for (; j < m; j++) {
                if (Integer.valueOf(nums2[j]) != 0)
                    return -1;
            }
            return 0;
        }
        return 0;
    }
}