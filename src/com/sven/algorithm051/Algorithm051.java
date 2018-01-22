package com.sven.algorithm051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm051 {

    public static void main(String[] args) {
        List<List<String>> ans = new Solution2().solveNQueens(4);
    }
}

class Solution {

    private int n;
    private int[] nums;
    private char[] ch;
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.nums = new int[n];
        this.ch = new char[n];
        this.ans = new ArrayList<>();
        for (int i = 0; i < n; i++) nums[i] = i;
        Arrays.fill(ch, '.');
        core(0);
        return ans;
    }

    private void core(int level) {
        if (level == n) {
            List<String> suc = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ch[nums[i]] = 'Q';
                suc.add(new String(ch));
                ch[nums[i]] = '.';
            }
            ans.add(suc);
            suc.forEach(s -> System.out.print(s + " "));
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check(i, level)) continue;
            nums[level] = i;
            core(level + 1);
            nums[level] = 0;
        }
    }

    private boolean check(int n, int level) {
        for (int i = 0; i < level; i++) {
            if (nums[i] == n || i - level == nums[i] - n || level - i == nums[i] - n)
                return false;
        }
        return true;
    }
}

/**
 * 《剑指offer》P158
 */
class Solution2 {

    private int n;
    private int[] nums;
    private char[] ch;
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.nums = new int[n];
        this.ch = new char[n];
        this.ans = new ArrayList<>();
        for (int i = 0; i < n; i++) nums[i] = i;
        Arrays.fill(ch, '.');
        permute(0);
        return ans;
    }

    private boolean check() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i - j == nums[i] - nums[j] || j - i == nums[i] - nums[j])
                    return false;
            }
        }
        return true;
    }

    private void permute(int first) {
        if (first == n - 1) {
            if (check()) {
                List<String> suc = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ch[nums[i]] = 'Q';
                    suc.add(new String(ch));
                    ch[nums[i]] = '.';
                }
                ans.add(suc);
                suc.forEach(s -> System.out.print(s + " "));
                System.out.println();
            }
            return;
        }

        for (int i = first; i < n; i++) {
            swap(first, i);
            permute(first + 1);
            swap(first, i);
        }
    }

    private void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}