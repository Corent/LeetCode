package com.sven.algorithm035;

public class Algorithm035 {
}

/**
 * 二分查找，找到就是mid，找不到就是left
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}