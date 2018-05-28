package com.sven.algorithm119;

import java.util.ArrayList;
import java.util.List;

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