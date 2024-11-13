package com.sven.algorithm018;

import java.util.*;

public class Algorithm018 {
}

/**
 * 转为Algorithm015 3sum问题
 */
class Solution {

    private List<List<Integer>> twoSum(int[] nums, int from, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length < 2) return ans;
        int i = from, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) i++;
            else j--;
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int from, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = from; i < nums.length - 2; i++) {
            if (i > from && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> tmp = twoSum(nums, i + 1, target - nums[i]);
            if (tmp.isEmpty()) continue;
            for (List<Integer> t: tmp) {
                t.add(0, nums[i]);
                ans.add(t);
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> tmp = threeSum(nums, i + 1, target - nums[i]);
            if (tmp.isEmpty()) continue;
            for (List<Integer> t: tmp) {
                t.add(0, nums[i]);
                ans.add(t);
            }
        }
        return ans;
    }
}