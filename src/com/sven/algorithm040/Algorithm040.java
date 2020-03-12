package com.sven.algorithm040;

import java.util.*;

public class Algorithm040 {

    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        for (List<Integer> list: ans) {
            for (Integer i: list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

/**
 * 在上一题基础上改动，递归的时候游标前移，结果注意去重
 */
class Solution {

    private int[] candidates;
    private List<Integer> current = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    private Set<String> anSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        this.candidates = candidates;
        resolve(0, target);
        return ans;
    }

    public void resolve(int idx, int target) {
        if (target <= 0) {
            if (target == 0) {
                StringBuilder builder = new StringBuilder();
                for (Integer i: current) builder.append(i).append('|');
                String key = builder.toString();
                if (anSet.contains(key)) return;
                ans.add(new ArrayList<>(current));
                anSet.add(key);
            }
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            current.add(candidates[i]);
            resolve(i + 1, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}

/**
 * https://www.cnblogs.com/ariel-dreamland/p/9138654.html
 */
class Solution2 {

    private int[] candidates;
    private List<Integer> current = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();
    private Set<String> anSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            resolve(i + 1, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}