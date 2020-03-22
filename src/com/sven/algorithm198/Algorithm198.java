package com.sven.algorithm198;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/8
 */
public class Algorithm198 {
}

/**
 * 经典DP dp[i] = max(dp[i - 2], dp[i - 3]) + num[i]
 * https://blog.csdn.net/derrantcm/article/details/47970775
 */
class Solution {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        // 如果数组中的元素个个数大于2个，对于递推公式，i=2，dp[2-3]不存在
        if (nums.length > 2) nums[2] += nums[0];

        // 从第四个元素开始处理
        int i = 3;
        for (; i < nums.length; i++) {
            // 求出第i个元素的最大值
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }

        if (nums.length == 1)   {// 如果只有一个元素，返回这个元素值
            return nums[0];
        } else if (nums.length == 2) {    // 有两个元素返回其中较大的值
            return Math.max(nums[0], nums[1]);
        } else { // 多于两个元素，最大值在末尾两个之间，找最大的返回
            return Math.max(nums[i - 1], nums[i - 2]);
        }
    }
}

/**
 * My solution
 */
class Solution2 {
    public int rob(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        int[] robYes = new int[nums.length], robNo = new int[nums.length];
        robYes[0] = nums[0];
        robNo[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            robYes[i] = robNo[i - 1] + nums[i];
            robNo[i] = Math.max(robYes[i - 1], robNo[i - 1]);
        }
        return Math.max(robYes[nums.length - 1], robNo[nums.length - 1]);
    }
}