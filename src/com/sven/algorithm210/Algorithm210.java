package com.sven.algorithm210;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/10
 */
public class Algorithm210 {
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer>[] nexts = new Set[numCourses], prevs = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nexts[i] = new HashSet<>();
            prevs[i] = new HashSet<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int s = prerequisites[i][0], e = prerequisites[i][1];
            nexts[s].add(e);
            prevs[e].add(s);
        }

        List<Integer> ans = new ArrayList<>(numCourses);
        Integer zeroPrev = null, cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (prevs[i] != null && prevs[i].size() == 0) {
                zeroPrev = i;
                break;
            }
        }
        while (zeroPrev != null) {
            ans.add(zeroPrev);
            final int zeroPrevIdx = zeroPrev;
            nexts[zeroPrev].parallelStream().forEach(idx -> prevs[idx].remove(zeroPrevIdx));
            prevs[zeroPrev] = null;
            cnt++;

            zeroPrev = null;
            for (int i = 0; i < numCourses; i++) {
                if (prevs[i] != null && prevs[i].size() == 0) {
                    zeroPrev = i;
                    break;
                }
            }
        }
        if (cnt != numCourses) ans.clear();
        int n = ans.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = ans.get(n - 1 - i);
        return res;
    }
}