package com.sven.algorithm307;

public class Algorithm307 {

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.print((i & -i) + " ");
        }

        NumArray2 obj = new NumArray2(new int[] {1, 3, 5});
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
        System.out.println();
    }
}

/**
 * 效率低
 */
class NumArray {

    private int n;
    private int[] sum;
    private int[] nums;

    public NumArray(int[] nums) {
        n = nums.length;
        sum = new int[n];
        this.nums = nums;
        for (int i = 0; i < n; i++) {
            sum[i] = i == 0? nums[i]: nums[i] + sum[i - 1];
        }
    }

    public void update(int i, int val) {
        if (i >= n) return;
        int oldVal = nums[i];
        if (oldVal == val) return;
        nums[i] = val;
        int diff = val - oldVal;
        for (; i < n; i++) {
            sum[i] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return i == 0? sum[j]: sum[j] - sum[i - 1];
    }
}

/**
 * 树状数组
 * https://blog.csdn.net/dreamgchuan/article/details/51173561
 * https://www.cnblogs.com/xenny/p/9739600.html
 */
class NumArray2 {

    private int[] sums;
    private int[] nums;

    public NumArray2(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            change(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        change(i + 1, delta);
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int lowbit(int x){
        return x & (-x);
    }

    private int sum(int n){
        int sum = 0;
        while (n > 0) {
            sum += sums[n];
            n -= lowbit(n);
        }
        return sum;
    }

    private void change(int i, int val){
        while(i < sums.length){
            sums[i] += val;
            i += lowbit(i);
        }
    }
}