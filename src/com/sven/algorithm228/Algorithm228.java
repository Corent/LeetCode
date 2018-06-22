package com.sven.algorithm228;

import java.util.ArrayList;
import java.util.List;

public class Algorithm228 {
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        for (int i = 0, n = nums.length; i < n; ) {
            int j = i + 1;
            while (j < n && nums[j] == nums[i] + j - i) j++;
            ans.add(j - i == 1? String.valueOf(nums[i]): nums[i] + "->" + nums[j - 1]);
            i = j;
        }
        return ans;
    }
}