package com.sven.algorithm031;

/**
 * http://blog.csdn.net/nomasp/article/details/49913627
 * http://blog.csdn.net/linhuanmars/article/details/20434115
 */
public class Algorithm031 {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 6, 5, 4, 1 };
        new Solution().nextPermutation(nums);
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) idx--;
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int target = idx + 1;
        while (target < nums.length && nums[target] > nums[idx]) target++;
        swap(nums, idx, target - 1);
        reverse(nums, idx + 1, nums.length - 1);
    }
}