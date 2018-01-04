package com.sven.algorithm027;

public class Algorithm027 {

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 2, 3 };
        int cnt = new Solution().removeElement(nums, 3);
        for (int i = 0; i < cnt; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

/**
 * 左右两个指针i j，i向右查找val值，j向左寻找非val值，交换
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[j] == val) j--;
            while (i <= j && nums[i] != val) i++;
            if (i < j && nums[i] == val && nums[j] != val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return i;
    }
}