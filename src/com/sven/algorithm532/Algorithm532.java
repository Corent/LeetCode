package com.sven.algorithm532;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Algorithm532 {
}

class Solution {

    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    ans++;
                    int j = i + 1;
                    while (j < nums.length && nums[j] == nums[i]) j++;
                    i = j - 1;
                }
            }
            return ans;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) continue;
            if (set.contains(nums[i] + k)) ans++;
            set.remove(nums[i]);
        }
        return ans;
    }
}