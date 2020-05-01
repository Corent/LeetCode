package com.sven.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algorithm {

    public static void main(String[] args) {

        int[] nums = new int[] {5, 6, 2, 8, 1, 7, 3, 0, 4};
        qsort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private static void qsort(int[] nums, int from, int to) {
        if (nums == null || nums.length == 0 || from >= to) return;
        int idx = partition(nums, from, to);
        qsort(nums, from, idx - 1);
        qsort(nums, idx + 1, to);
    }

    private static int partition(int[] nums, int from, int to) {
        int left = from, right = to;
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > tmp) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] < tmp) left++;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }

    private int[] getRands(int m, int n) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, n).forEach(e -> list.add(e));
        Collections.shuffle(list);
        list.stream().limit(m).collect(Collectors.toList());
        int[] ans = new int[m];
        Arrays.asList(ans);
        return ans;
    }
}