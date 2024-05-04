package com.sven.algorithm004;

public class Algorithm004 {
}

/**
 * https://www.cnblogs.com/springfor/p/3861890.html
 * 转化为查找两个排序数组第K个数的问题
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        if (total % 2 != 0) // 对奇数来说，就是求第(m+n)/2+1（从1开始数）大的数
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        else                // 对偶数来说，就是求第(m+n)/2大（从1开始数）和第(m+n)/2+1大（从1开始数）的数的算术平均值
            return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2) +
                    findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1)) / 2;
    }

    private double findKth(int[] nums1, int from1, int to1, int[] nums2, int from2, int to2, int k) {
        int m = to1 - from1 + 1, n = to2 - from2 + 1; // 比较两个数组的长度
        if (m > n) return findKth(nums2, from2, to2, nums1, from1, to1, k); // 保证第一个数组长度小于等于第二个数组
        if (m == 0) return nums2[k - 1]; //若第一个数组长度为0，则第二个数组中nums2[k - 1]即为所求
        if (k == 1) return Math.min(nums1[from1], nums2[from2]); // 若k = 1，则两个数组起始位置的最小值即为所求
        int pos1 = Math.min(k / 2, m); // pos1取 k/2 和 m 的最小值，from1 + pos1 - 1是第一个数组的中位数位置
        int pos2 = k - pos1; // pos2取k - pos1，保证pos2 - pos1 = k，from2 + pos2 - 1]是第二个数组的中位数位置
        if (nums1[from1 + pos1 - 1] < nums2[from2 + pos2 - 1]) // 如果第一个数组的中位数小于第二个数组的中位数，
                                                                // 则第一个数组取后半部分，再和第二个数组进行比较，查找第k - pos1大的数
            return findKth(nums1, from1 + pos1, to1, nums2, from2, to2, k - pos1);
        else if (nums1[from1 + pos1 - 1] > nums2[from2 + pos2 - 1]) // 如果第一个数组的中位数大于第二个数组的中位数，
                                                                    // 则第二个数组取后半部分，再和第一个数组进行比较，查找第k - pos2大的数
            return findKth(nums1, from1, to1, nums2, from2 + pos2, to2, k - pos2);
        else return nums1[from1 + pos1 - 1]; // 如果两者相等，则该位置即为所求，第一个数组的中位数nums1[from1 + pos1 - 1]
                                            // 或者第二个数组的中位数nums2[from2 + pos2 - 1]就是所求
    }
}

/*
* https://blog.csdn.net/xiaoguaihai/article/details/81264148
*/
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {    // 保证m<n, 避免j出现负数
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;

            int temp = m;
            m = n;
            n = temp;
        }

        int halfLen = (m + n + 1) / 2;
        int iMin = 0, iMax = m; // 对i进行折半查找
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < m && nums1[i] < nums2[j - 1]) { // i的值偏小
                iMin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) { // i的值偏大
                iMax = i - 1;
            } else { // i的值正好
                int maxLeft = 0;
                if (i == 0) {   // nums1的左半边为空
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {    // nums2的左半边为空
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                // 如果总数是奇数，则中位数是左半部分最大的数；否则为左边最大和右边最小数的平均值
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {   // nums1的右半边为空
                    minRight = nums2[j];
                } else if (j == n) {    // nums2的右半边为空
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}