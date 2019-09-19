package com.sven.algorithm327;

public class Algorithm327 {

    public static void main(String[] args) {
        System.out.println(new Solution().countRangeSum(new int[] {-1, 1}, 0, 0));
    }
}

class Solution {

    private int[] nums;
    private long[] sums;
    private int lower;
    private int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;
        this.lower = lower;
        this.upper = upper;
        this.nums = nums;

        if (n == 0) return 0;
        sums = new long[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        return countNum(0, n - 1);
    }

    private int countNum(int left, int right) {
        if (left == right)
            return nums[left] >= lower && nums[right] <= upper? 1: 0;
        int mid = left + (right - left) / 2, total = 0;
        for (int i = left; i <= mid; i++) {
            for (int j = mid + 1; j <= right; j++) {
                long diff = sums[j] - sums[i] + nums[i];
                if (diff >= lower && diff <= upper)
                    total++;
            }
        }
        return total + countNum(left, mid) + countNum(mid + 1, right);
    }
}