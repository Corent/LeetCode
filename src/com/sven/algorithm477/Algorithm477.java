package com.sven.algorithm477;

public class Algorithm477 {
}

/**
 * 超时
 */
class Solution {

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans += hammingDistance(nums[i], nums[j]);
            }
        }
        return ans;
    }

    private int hammingDistance(int x, int y) {
        int n = x ^ y, cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }
}

/**
 * https://www.jianshu.com/p/8f127578fe73
 */
class Solution2 {

    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] m = new int[31];// 存储对应位数，有多少个0
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) == 0) {
                    m[i]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 31; i++) {
            result += m[i] * (nums.length - m[i]);
        }

        return result;
    }
}

/**
 * https://blog.csdn.net/obrcnh/article/details/78442853
 */
class Solution3 {

    public int totalHammingDistance(int[] nums) {
        return 0;
    }
}