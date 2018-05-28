package com.sven.algorithm118;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/28
 */
public class Algorithm118 {
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) return ans;
        int idxRow = 2;
        ans.add(new ArrayList<Integer>(1) {{ add(1); }});
        while (idxRow <= numRows) {
            int size = ans.size();
            List<Integer> lastRow = ans.get(size - 1);
            List<Integer> nextRow = new ArrayList<>(size);
            nextRow.add(1);
            for (int i = 1; i < idxRow - 1; i++) nextRow.add(lastRow.get(i - 1) + lastRow.get(i));
            nextRow.add(1);
            ans.add(nextRow);
            idxRow++;
        }
        return ans;
    }
}