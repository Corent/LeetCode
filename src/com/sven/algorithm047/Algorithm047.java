package com.sven.algorithm047;

import java.util.*;

public class Algorithm047 {
}

/**
 * 参考Algorithm046，加入结果集的时候加个校验，但这种方法效率低
 */
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> ansKeys = new HashSet<>();
        if (nums == null || nums.length == 0) return ans;
        int cnt = 1;
        for (int i = 1; i <= nums.length; i++) cnt *= i;
        for (int i = 0; i < cnt; i++) {
            List<Integer> permutation = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for (int n: nums) {
                builder.append(n).append('|');
                permutation.add(n);
            }
            String key = builder.toString();
            if (!ansKeys.contains(key)) {
                ans.add(permutation);
                ansKeys.add(key);
            }
            nextPermutation(nums);
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }

    private void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) idx--;
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int target = idx + 1;
        while (target < nums.length && nums[target] > nums[idx]) target++;
        swap(nums, idx, target - 1);
        reverse(nums, idx + 1, nums.length - 1);
    }
}

class Solution2 {

    private int[] nums;
    private List<Integer> permute = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        this.nums = nums;
        permute();
        return ans;
    }

    private void permute() {
        if (permute.size() == nums.length) {
            ans.add(new ArrayList<>(permute));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;

            used[i] = true;
            permute.add(nums[i]);
            permute();
            permute.remove(permute.size() - 1);
            used[i] = false;
        }
    }
}