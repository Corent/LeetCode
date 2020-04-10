package com.sven.algorithm033;

public class Algorithm033 {
}

class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }

        return -1;
    }
}

/**
 * 剑指Offer面试题8 or LeetCode 153
 * 先找出旋转数组中的最小值，判断target在哪个有序段内，再在有序段内二分查找
 */
class Solution2 {

    //在一个有序数列中查找
    public int seatch(int[] nums, int from, int to, int target) {
        while (from <= to) {
            int mid = (from + to) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) to = mid - 1;
            else from = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int i = 0, j = nums.length - 1, mid = i;
        if (nums[i] <= nums[j]) return seatch(nums, i, j, target);
        while (nums[i] >= nums[j]) {
            if (j - i == 1) {
                mid = j;
                break;
            }

            mid = (i + j) / 2;
            if (nums[mid] >= nums[i]) i = mid;
            else if (nums[mid] <= nums[j]) j = mid;
        }

        if (mid == 0 || target >= nums[mid] && target <= nums[nums.length - 1]) return  seatch(nums, mid, nums.length - 1, target);
        else if (target >= nums[0] && target <= nums[mid - 1]) return seatch(nums, 0, mid - 1, target);

        return -1;
    }
}
