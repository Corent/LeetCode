package com.sven.algorithm496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Algorithm496 {
}

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
        int[] greaters = new int[nums1.length];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int idx = map.get(nums1[i]) + 1;
            greaters[i] = -1;
            while (idx < nums2.length && nums2[idx] < nums1[i]) idx++;
            if (idx < nums2.length) greaters[i] = nums2[idx];
        }
        return greaters;
    }
}