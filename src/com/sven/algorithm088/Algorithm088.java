package com.sven.algorithm088;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm088 {
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for (int i = 0; i < m; i++) nums3[i] = nums1[i];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i == m) nums1[k++] = nums2[j++];
            else if (j == n) nums1[k++] = nums3[i++];
            else {
                if (nums2[j] < nums3[i]) nums1[k++] = nums2[j++];
                else nums1[k++] = nums3[i++];
            }
        }
    }
}

/**
 * https://blog.csdn.net/u011750466/article/details/80075081
 */
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        while (m > 0 && n > 0) {
            nums1[--k] = nums1[m - 1] >= nums2[n - 1] ? nums1[--m] : nums2[--n];
        }
        while (n > 0) {
            nums1[--k] = nums2[--n];
        }
    }
}