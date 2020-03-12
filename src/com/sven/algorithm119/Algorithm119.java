package com.sven.algorithm119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/28
 */
public class Algorithm119 {
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> ans = new ArrayList<>();
        if (rowIndex <= 0) return ans;
        int idxRow = 2;
        ans.add(1);
        while (idxRow <= rowIndex) {
            int size = ans.size();
            List<Integer> lastRow = ans;
            ans = new ArrayList<>(size + 1);
            ans.add(1);
            for (int i = 1; i < idxRow - 1; i++) ans.add(lastRow.get(i - 1) + lastRow.get(i));
            ans.add(1);
            idxRow++;
        }
        return ans;
    }
}

class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] nums = new Integer[rowIndex + 1];
        nums[0] = 1;
        for (int idx = 1; idx <= rowIndex; idx++) {
            nums[idx] = 1;
            for (int rowIdx = idx - 1; rowIdx > 0; rowIdx--) {
                nums[rowIdx] += nums[rowIdx - 1];
            }
        }
        return Arrays.asList(nums);
    }
}