package com.sven.baidu;

import java.util.Arrays;

public class HeapSort {
    
    private int[] nums;
    
    public void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        this.nums = nums;
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            adjust(i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) { 
            swap(0, i);
            adjust(0, i);
        }
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void adjust(int parent, int length) {
        int tmp = nums[parent], child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }

            if (tmp >= nums[child]) break;
            nums[parent] = nums[child];

            parent = child;
            child = 2 * child + 1;
        }
        nums[parent] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 5, 7, 1, 0, 9, 6, 2, 8, 4 };
        new HeapSort().heapSort(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }
}