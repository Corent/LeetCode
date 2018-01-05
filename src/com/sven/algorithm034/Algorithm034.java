package com.sven.algorithm034;

public class Algorithm034 {

    public static void main(String[] args) {
        int[] ans = new Solution().searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

/**
 * 方法一：折半查找，找到后从左右两边查找
 * 方法二：第一次折半查找某个相等元素的位置，第二次折半查找左边界，第三次折半查找右边界
 * 方法三：方法二的优化，只用两次折半，第一次折半查找左边界，第二次折半查找右边界
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) return ans;
        int left = 0, right = nums.length - 1;
        while (left <= right && nums[left] <= target && nums[right] >= target) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                right = mid - 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (ans[0] == -1) return ans;
        left = 0;
        right = nums.length - 1;
        while (left <= right && nums[left] <= target && nums[right] >= target) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                left = mid + 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }
}