package com.sven.Wuba;

public class Algorithm {

    public void sortOddEven(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int odd = 0, even = nums.length - 1;
        while (odd < even) {
            while (odd < even && (nums[odd] & 1) != 0) odd++;
            while (odd < even && (nums[even] & 1) == 0) even--;
            int tmp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = tmp;
        }
    }
}
// redis zset