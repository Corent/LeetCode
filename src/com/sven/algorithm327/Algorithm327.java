package com.sven.algorithm327;

import java.util.TreeMap;

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
        if (left == right) return nums[left] >= lower && nums[right] <= upper? 1: 0;
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

/**
 * https://blog.csdn.net/jmspan/article/details/51266931
 */
class Solution2 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) sums[i] = sums[i - 1] + nums[i];
        int total = 0;
        TreeMap<Long, Integer> treemap = new TreeMap<>();   //  前缀和相同的可能有多个
        for (int i = 0; i < nums.length; i++) {
            if (lower <= sums[i] && sums[i] <= upper) {
                total++;
            }
            //  sums[i] - upper <= x <= sums[i] - lower
            //  lower <= sums[i] - x <= upper
            for (Integer count : treemap.subMap(sums[i] - upper, true, sums[i] - lower, true).values()) {
                total += count;
            }
            Integer count = treemap.get(sums[i]);
            treemap.put(sums[i], count == null ? 1 : count + 1);
        }
        return total;
    }
}