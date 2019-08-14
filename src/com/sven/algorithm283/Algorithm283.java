package com.sven.algorithm283;

import java.util.Arrays;

public class Algorithm283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int idxOfZero = -1, idxOfNonZero = -1;
        while (idxOfNonZero < nums.length) {
            while (++idxOfZero < nums.length && nums[idxOfZero] != 0);
            idxOfNonZero = idxOfZero;
            while (++idxOfNonZero < nums.length && nums[idxOfNonZero] == 0);
            if (idxOfZero < nums.length && idxOfNonZero < nums.length) {
                swap(nums, idxOfZero, idxOfNonZero);
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] =- tmp;
    }
}