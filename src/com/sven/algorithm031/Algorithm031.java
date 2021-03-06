package com.sven.algorithm031;

/**
 * http://blog.csdn.net/nomasp/article/details/49913627
 * http://blog.csdn.net/linhuanmars/article/details/20434115
 *
 * (2,3,6,5,4,1)
 * 求下一个排列的基本步骤是这样：
 * 1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
 * 2) 接下来分两种情况：
 *     (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
 *     (2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，比如例子中的4。调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
 */
public class Algorithm031 {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 6, 5, 4, 1 };
        new Solution().nextPermutation(nums);
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) idx--;
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int target = idx + 1;
        while (target < nums.length && nums[target] > nums[idx]) target++;
        swap(nums, idx, target - 1);
        reverse(nums, idx + 1, nums.length - 1);
    }
}