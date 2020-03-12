package com.sven.algorithm042;

public class Algorithm042 {

    public static void main(String[] args) {
        System.out.println(new Solution2().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}

/**
 * 方法一：对于每一个bar从左右两边扫，找出每个bar能够承受的最大水量 O(n^2) O(1)
 * 方法二：一维动规，一个数组存储从左往右扫每个bar此前的最大高度，第二次从右往左扫每个bar此前的最大高度，计算每个bar能承受的最大水量，累加 O(n) O(n)
 * 方法三：左右双指针向中间扫描，判断两端高低，从低的一端向中间扫描，比这个高度低的都累加，直到比这个高度高的停止，重新比较左右两端高低 O(n) O(1)
 */
class Solution2 {
    public int trap(int[] height) {
        int ans = 0;
        if (height.length < 3) return ans;
        int[] leftTop = new int[height.length], rightTop = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            leftTop[i] = i == 0 ? height[i] : Math.max(height[i], leftTop[i - 1]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightTop[i] = i == height.length - 1 ? height[i] : Math.max(height[i], rightTop[i + 1]);
            ans += Math.min(leftTop[i], rightTop[i]) - height[i];
        }
        return ans;
    }
}

class Solution3 {
    public int trap(int[] height) {
        int ans = 0;
        if (height.length < 3) return ans;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int lowPeak = Math.min(height[left], height[right]);
            if (height[left] < height[right]) {
                while (left < right && height[left] <= lowPeak)
                    ans += lowPeak - height[left++];
            } else {
                while (left < right && height[right] <= lowPeak)
                    ans += lowPeak - height[right--];
            }
        }
        return ans;
    }
}