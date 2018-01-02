package com.sven.algorithm016;

import java.util.Arrays;

public class Algorithm016 {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }
}

/**
 * 先排序，固定第一个值的位置i，后两个数的位置根据sum与target的大小调整
 */
class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE, diff;
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        ans = nums[0] + nums[1] + nums[2];
        diff = Math.abs(ans - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int newDiff = Math.abs(sum - target);
                if (diff > newDiff) {
                    diff = newDiff;
                    ans = sum;
                }
                if (sum < target) j++;
                else k--;
            }
        }
        return ans;
    }
}