package com.sven.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lgAorithm001 {

    public static void main(String[] args) {
        int[] result = new Solution().twoSum(new int[] {3, 2, 4}, 6);
        Arrays.stream(result).forEach(num -> System.out.println(num + " "));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[] {};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[] { map.get(nums[i]), i };
            map.put(target - nums[i], i);
        }
        return new int[] {};
    }
}