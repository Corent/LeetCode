package com.sven.algorithm004;

public class Algorithm004 {
}

/**
 * https://www.cnblogs.com/springfor/p/3861890.html
 * 转化为查找两个排序数组第K大的数的问题
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if (total % 2 != 0)
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        else
            return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2) +
                    findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1)) / 2;
    }

    private double findKth(int[] nums1, int from1, int to1, int[] nums2, int from2, int to2, int k) {
        int m = to1 - from1 + 1, n = to2 - from2 + 1;
        if (m > n) return findKth(nums2, from2, to2, nums1, from1, to1, k);
        if (m == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[from1], nums2[from2]);
        int pos1 = Math.min(k / 2, m);
        int pos2 = k - pos1;
        if (nums1[from1 + pos1 - 1] < nums2[from2 + pos2 - 1])
            return findKth(nums1, from1 + pos1, to1, nums2, from2, to2, k - pos1);
        else if (nums1[from1 + pos1 - 1] > nums2[from2 + pos2 - 1])
            return findKth(nums1, from1, to1, nums2, from2 + pos2, to2, k - pos2);
        else return nums1[from1 + pos1 - 1];
    }
}