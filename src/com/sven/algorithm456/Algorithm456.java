package com.sven.algorithm456;

import java.util.Stack;

public class Algorithm456 {
}

/**
 * https://blog.csdn.net/u011693064/article/details/54650260
 */
class Solution {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length <= 2) return false;
        int n = nums.length, i = 0, j = 0, k = 0;
        while (i < n) {
            while (i < n - 1 && nums[i] >= nums[i + 1]) ++i;
            j = i + 1;
            while (j < n - 1 && nums[j] <= nums[j + 1]) ++j;
            k = j + 1;
            while (k < n) {
                if (nums[k] > nums[i] && nums[k] < nums[j]) return true;
                ++k;
            }
            i = j + 1;
        }
        return false;
    }
}


class Solution2 {

    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) third = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}