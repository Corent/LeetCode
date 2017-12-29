package com.sven.algorithm011;

public class Algorithm011 {
}

/**
 * http://blog.csdn.net/ljiabin/article/details/41673753
 */
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int max = Integer.MIN_VALUE, i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) i++;    //把小的一端相向移动，舍弃其与两点之间其他线段组成的木桶，因为这些木桶都不可能比当前的木桶容量大（高不变宽变小）
            else j--;
        }
        return max;
    }
}