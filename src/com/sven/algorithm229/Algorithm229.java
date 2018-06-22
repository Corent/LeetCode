package com.sven.algorithm229;

import java.util.ArrayList;
import java.util.List;

public class Algorithm229 {
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(2);
        if (nums == null || nums.length == 0) return ans;

        int m = 0, n = 0, mCnt = 0, nCnt = 0, cnt = nums.length / 3;
        for (int num: nums) {
            if (num == m) mCnt++;
            else if (num == n) nCnt++;
            else if (mCnt == 0) {
                m = num;
                mCnt = 1;
            } else if (nCnt == 0) {
                n = num;
                nCnt = 1;
            } else {
                mCnt--;
                nCnt--;
            }
        }

        mCnt = nCnt = 0;
        for (int num: nums) {
            if (num == m) mCnt++;
            else if (num == n) nCnt++;
        }

        if (mCnt > cnt) ans.add(m);
        if (nCnt > cnt) ans.add(n);

        return ans;
    }
}