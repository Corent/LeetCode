package com.sven.algorithm052;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm052 {
}
class Solution {

    private int n;
    private int[] nums;
    private char[] ch;
    private int cnt;

    public int totalNQueens(int n) {
        this.n = n;
        this.nums = new int[n];
        this.ch = new char[n];
        for (int i = 0; i < n; i++) nums[i] = i;
        Arrays.fill(ch, '.');
        core(0);
        return cnt;
    }

    private void core(int level) {
        if (level == n) {
            cnt++;
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