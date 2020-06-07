package com.sven.algorithm491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algorithm491 {
}

class Solution {

    private int[] nums;
    private Set<List<Integer>> ans = new HashSet<>(); // 存放结果

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        findSubList(0, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void findSubList(int index, List<Integer> subsequence) {
        if (subsequence.size() >= 2) {    // 递增子序列的长度至少是2
            ans.add(new ArrayList<>(subsequence));
        }
        for (int i = index; i < nums.length; i++) {
            if (subsequence.size() == 0 || subsequence.get(subsequence.size() - 1) <= nums[i]) {
                subsequence.add(nums[i]);
                findSubList(i + 1, subsequence);   // 进行递归
                subsequence.remove(subsequence.size() - 1);
            }
        }
    }
}