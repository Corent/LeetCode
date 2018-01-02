package com.sven.algorithm015;

import java.util.*;

public class Algorithm015 {
}

/**
 * 参考Algorithm001 2sum，注意去重
 */
class Solution {

    private List<List<Integer>> twoSum(int[] nums, int from, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 2) return ans;
        int i = from, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                ans.add(list);
                while (i < j && nums[i] == nums[i + 1]) i++;    //左右两端都跳过相同的
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) i++;
            else j--;
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //跳过相同的
            List<List<Integer>> tmp = twoSum(nums, i + 1, -nums[i]);
            if (tmp.isEmpty()) continue;
            for (List<Integer> t: tmp) {
                t.add(0, nums[i]);
                ans.add(t);
            }
        }
        return ans;
    }
}