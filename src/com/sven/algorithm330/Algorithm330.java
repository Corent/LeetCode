package com.sven.algorithm330;

public class Algorithm330 {
}

/**
 * 贪心算法
 * https://blog.csdn.net/magicbean2/article/details/76583378
 */
class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0, ans = 0;
        long bound = 1, m = nums.length;    //  bound表示能够覆盖 [0, bound) 区间内的数
        while (bound <= n) {
            if (i < m && nums[i] <= bound) bound += nums[i++];  // 数组内下一个数已经被包含在 [0, bound) 或者等于 bound，多了 nums[i + 1] 这个数会使得覆盖范围扩大为 [0, bound + nums[i + 1])
            else {
                bound <<= 1;    //  补贴一个 bound，可覆盖的范围就变为 [0, bound + bound - 1]， 也就是 [0, bound * 2)
                ans++;          //  原先已经能够覆盖 [0, 1, 2, 3, ... bound - 1]
            }                   //  如果补贴一个bound的话，可以覆盖 [0, 1, 2, 3, ... bound - 1, bound + 0, bound + 1, bound + 2, bound + 3 ... bound + bound - 1]
        }
        return ans;
    }
}