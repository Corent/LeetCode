package com.sven.algorithm421;

import java.util.HashSet;

public class Algorithm421 {
}

/**
 * https://kingsfish.github.io/2017/12/15/Leetcode-421-Maximum-XOR-of-Two-Numbers-in-an-Array/
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);     // 为获取前n位的临时变量
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(mask & num);    // 将所有数字的前n位放入set中
            }

            int tmp = max | (1 << i);   // 假定第n位为1,前n-1位max为之前迭代求得
            for (int pre : set) {
                if (set.contains(tmp ^ pre)) {  // 查看`b`是否在
                    max = tmp;          // b存在，第n位为1
                    break;
                }
            }
        }
        return max;
    }
}