package com.sven.algorithm303;

public class Algorithm303 {

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
    }
}

class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = i == 0? nums[0]: sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0? sum[j]: sum[j] - sum[i - 1];
    }
}