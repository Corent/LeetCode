package com.sven.algorithm046;

import java.util.ArrayList;
import java.util.List;

public class Algorithm046 {
}

/**
 * 参考Algorithm031
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        int cnt = 1;
        for (int i = 1; i <= nums.length; i++) cnt *= i;
        for (int i = 0; i < cnt; i++) {
            List<Integer> permutation = new ArrayList<>();
            for (int n: nums) permutation.add(n);
            ans.add(permutation);
            nextPermutation(nums);
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
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

    private void nextPermutation(int[] nums) {
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

/**
 * 递归回溯，两两交换
 */
class Solution2 {

    private int[] nums;
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        permute(0);
        return ans;
    }

    private void permute(int first) {
        if (first == nums.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int n: nums) permutation.add(n);
            ans.add(permutation);
            return;
        }

        for (int i = first; i < nums.length; i++) {
            swap(first, i);
            permute(first + 1);
            swap(first, i);
        }
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}