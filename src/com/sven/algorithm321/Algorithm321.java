package com.sven.algorithm321;

import java.util.Arrays;
import java.util.LinkedList;

public class Algorithm321 {

    public static void main(String[] args) {
        int[] ans = new Solution().maxNumber(new int[] {6, 7, 5}, new int[] {4, 8, 1}, 3);
        Arrays.stream(ans).boxed().forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}

/**
 * https://blog.csdn.net/w5688414/article/details/86775058
 */
class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - n); i<= Math.min(k, m); i++) {
            int[] next = merge(max(nums1, i), max(nums2, k - i));
            ans = compare(ans, 0, next, 0)? ans: next;
        }
        return ans;
    }

    private boolean compare(int[] nums1, int idx1, int[] nums2, int idx2) {
        for (; idx1 < nums1.length && idx2 < nums2.length; idx1++, idx2++) {
            if (nums1[idx1] > nums2[idx2]) return true;
            if (nums1[idx1] < nums2[idx2]) return false;
        }
        return idx1 != nums1.length;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            ans[k++] = compare(nums1, i, nums2, j)? nums1[i++]: nums2[j++];
        }
        return ans;
    }

    private int[] max(int[] nums, int k) {
        int drop = nums.length - k;
        LinkedList<Integer> list = new LinkedList<>();
        for (int num: nums) {
            while (drop > 0 && !list.isEmpty() && list.getLast() < num) {
                list.pollLast();
                drop--;
            }
            list.addLast(num);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = list.pollFirst();
        return ans;
    }
}