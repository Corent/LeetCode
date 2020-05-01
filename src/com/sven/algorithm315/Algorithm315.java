package com.sven.algorithm315;

import java.util.ArrayList;
import java.util.List;

public class Algorithm315 {
}

/**
 * 基于归并排序
 * 原数组不变，pos[i] = j，表示原数组中排名第i个数据的元素下标是j
 * https://blog.csdn.net/jmspan/article/details/51219203
 *
 * https://www.bilibili.com/video/BV1k4411R7cS
 */
class Solution {

    private void sort(int[] nums, int[] smaller, int[] pos, int from, int to) {
        if (from >= to) return;
        int m = (from + to) / 2;
        sort(nums, smaller, pos, from, m);
        sort(nums, smaller, pos, m + 1, to);
        int[] merged = new int[to - from + 1];  // merged[i] = j 表示合并结束后，nums[from:to]数组中第i个数据的元素下标是j
        int i = from, j = m + 1, k = 0, jump = 0;
        while (i <= m || j <= to) {
            if (i > m) {    // 前半段数组已经遍历结束
                jump++;
                merged[k++] = pos[j++];
            } else if (j > to) {    // 后半段数组已遍历结束
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {  // 两段均未结束
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else {
                jump++;
                merged[k++] = pos[j++];
            }
        }
        for (int p = 0; p < merged.length; p++) pos[from + p] = merged[p];
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] smaller = new int[nums.length];
        int[] pos = new int[nums.length];
        for (int i = 0; i < pos.length; i++) pos[i] = i;
        sort(nums, smaller, pos, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) result.add(smaller[i]);
        return result;
    }
}

/**
 * 树状数组
 * https://www.cnblogs.com/xenny/p/9739600.html
 */
class Solution2 {

    private void sort(int[] nums, int[] pos, int from, int to) {
        if (from >= to) return;
        int m = (from + to) / 2;
        sort(nums, pos, from, m);
        sort(nums, pos, m+1, to);
        int[] merged = new int[to - from + 1];
        int i = from, j = m + 1, p = 0;
        while (i<=m || j<=to) {
            if (i > m) {
                merged[p++] = pos[j++];
            } else if (j > to) {
                merged[p++] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {
                merged[p++] = pos[i++];
            } else {
                merged[p++] = pos[j++];
            }
        }
        for (int k = 0; k < merged.length; k++) pos[from + k] = merged[k];
    }

    private int count(int[] sum, int s) {
        int count = 0;
        while (s > 0) {
            count += sum[s];
            s -= (s & -s);
        }
        return count;
    }

    private void update(int[] sum, int s) {
        while (s < sum.length) {
            sum[s]++;
            s += (s & -s);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] pos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) pos[i] = i;
        sort(nums, pos, 0, nums.length - 1);
        int[] seq = new int[nums.length];
        for (int i = 0, s = 0; i < pos.length; i++) {
            if (i == 0 || nums[pos[i]] != nums[pos[i - 1]]) seq[pos[i]] = ++s;
            else seq[pos[i]] = s;
        }
        int[] sum = new int[nums.length + 1];
        int[] smaller = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            smaller[i] = count(sum, seq[i] - 1);
            update(sum, seq[i]);
        }
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < smaller.length; i++) result.add(smaller[i]);
        return result;
    }
}