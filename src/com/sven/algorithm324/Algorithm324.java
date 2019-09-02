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