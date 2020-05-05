package com.sven.algorithm457;

public class Algorithm457 {

    public static void main(String[] args) {
        System.out.println(new Solution().circularArrayLoop(new int[] { -1, 2 }));
    }
}

/**
 * 参考 Algorithm 207
 * 拓扑排序
 */
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        return false;
    }
}

/**
 * 以每个位置为起点尝试，快慢指针，注意长度为1的环和保持相同方向
 * https://blog.csdn.net/SundyGuo/article/details/80915501
 */
class Solution2 {
    
    private int[] nums;

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            int j = i, k = nextIndex(i);
            while (nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0 && nums[i] * nums[nextIndex(k)] > 0) {
                if (j == k) {
                    if (j == nextIndex(j)) break;
                    return true;
                }
                j = nextIndex(j);
                k = nextIndex(nextIndex(k));
            }
        }
        return false;
    }

    private int nextIndex(int i) {
        int nextPosition = i + nums[i];
        return nextPosition >= 0 ? nextPosition % nums.length : nums.length + (nextPosition % nums.length);
    }
}