package com.sven.algorithm026;

public class Algorithm026 {
}

/**
 * 两个指针cnt和i，cnt指向没有重复元素的下一个位置，i用于遍历，因为是有序数组，出现重复只可能是nums[cnt - 1]和nums[i]相等
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        if (nums == null) return cnt;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0 || nums[cnt - 1] != nums[i])
                nums[cnt++] = nums[i];
        }
        return cnt;
    }
}