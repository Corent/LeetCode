package com.sven.algorithm473;

import java.util.Arrays;

public class Algorithm473 {
}

/**
 * DFS + 回溯
 * https://blog.csdn.net/qq_40803710/article/details/80274628   超时
 * https://blog.csdn.net/xxu_tianxin/article/details/104174933
 */
class Solution {

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) return false;
        int[] sums = new int[4];  //长度为4的数组sums来保存每个边的长度和
        Arrays.sort(nums);
        return helper(nums, sums, 0, sum / 4);
    }

    private boolean helper(int[] nums, int[] sums, int pos, int target) {
        if (pos >= nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target;
        }
        //对于当前这个火柴，尝试拼入上下左右四个边
        for (int i = 0; i < 4; ++i) {
            if (sums[i] + nums[pos] > target) continue;
            sums[i] += nums[pos]; //把当前火柴从i个边中拿出来，好尝试下一条边
            if (helper(nums, sums, pos + 1, target)) return true;  //如果这个火柴被成功使用，就开始尝试拼下一根火柴
            sums[i] -= nums[pos];  //用当前火柴拼第i个边
        }
        return false;
    }
}