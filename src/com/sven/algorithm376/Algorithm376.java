package com.sven.algorithm376;

import java.util.Arrays;

public class Algorithm376 {

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[] {1, 7, 4, 9, 2, 5}));
    }
}

class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 1;
        int[] preMax = new int[nums.length];
        int[] preMin = new int[nums.length];
        preMax[0] = preMin[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            preMax[0] = preMin[0] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    preMax[i] = Math.max(preMax[i], preMin[j] + 1);
                } else if (nums[j] < nums[i]) {
                    preMin[i] = Math.max(preMin[i], preMax[j] + 1);
                } else {
                    preMax[i] = Math.max(preMax[i], preMax[j]);
                    preMin[i] = Math.max(preMin[i], preMin[j]);
                }
            }
            ans = Math.max(ans, Math.max(preMax[i], preMin[i]));
        }
        return ans;
    }
}