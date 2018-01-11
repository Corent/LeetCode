package com.sven.algorithm041;

public class Algorithm041 {
}

/**
 * 数组调整为idx位置存储数值idx+1，从头遍历即可找出第一个缺失的数字
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            } else i++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }
}