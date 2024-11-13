package com.sven.algorithm324;

import java.util.Arrays;

public class Algorithm324 {
}

/**
 * 时空复杂度O(n) O(1)比较难，Hard水准
 * https://blog.csdn.net/Evildoer_llc/article/details/88783938
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        for (int i = 0, j = n, k = (n + 1) / 2; i < nums.length; i++) {
            nums[i] = (i & 1) == 0? sortedNums[--k]: sortedNums[--j];
        }
    }
}

/**
 * 基于快排partition函数，O(n)
 */
class Solution2 {

    public void wiggleSort(int[] nums) {
        int n = nums.length, k = (n + 1) / 2;
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        // Arrays.sort(sortedNums);
        findKthLargest(sortedNums, 0, sortedNums.length - 1, k);
        for (int i = 0, j = n; i < nums.length; i++) {
            nums[i] = (i & 1) == 0? sortedNums[--k]: sortedNums[--j];
        }
    }

    private int findKthLargest(int[] nums, int from, int to, int k) {
        while (from < to) {
            int i = from, j = to;
            while (i < j) {
                while (i < j && nums[j] >= nums[i]) j--;
                swap(nums, i, j);
                while (i < j && nums[i] <= nums[j]) i++;
                swap(nums, i, j);
            }
            if (i == k) return nums[i];
            if (i < k) from = i + 1;
            else to = i - 1;
        }
        return nums[from];
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int n = nums[i];
        nums[i] = nums[j];
        nums[j] = n;
    }
}