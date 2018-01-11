package com.sven.algorithm039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm039 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        for (List<Integer> list: ans) {
            for (Integer i: list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

/**
 * 递归回溯，每个元素都有取或不取，取多个的情况
 */
class Solution {

    private int[] candidates;
    private List<Integer> current = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        this.candidates = candidates;
        resolve(0, target);
        return ans;
    }

    public void resolve(int idx, int target) {
        if (target <= 0) {
            if (target == 0) ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            current.add(candidates[i]);
            resolve(i, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}