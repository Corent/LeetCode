package com.sven.algorithm207;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/9
 */
public class Algorithm207 {
}

/**
 * 拓扑排序
 */
class Solution {

    private int numCourses;
    private Set<Integer>[] nexts;
    private Set<Integer>[] prevs;

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        nexts = new Set[numCourses];
        prevs = new Set[numCourses];
        this.numCourses = numCourses;
        for (int i = 0; i < numCourses; i++) {
            nexts[i] = new HashSet<>();
            prevs[i] = new HashSet<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int s = prerequisites[i][0], e = prerequisites[i][1];
            nexts[s].add(e);
            prevs[e].add(s);
        }


        Integer zeroPrev = findNext(), cnt = 0;
        while (zeroPrev != null) {
            final int zeroPrevIdx = zeroPrev;
            nexts[zeroPrev].parallelStream().forEach(idx -> prevs[idx].remove(zeroPrevIdx));
            prevs[zeroPrev] = null;
            cnt++;
            zeroPrev = findNext();
        }
        return cnt == numCourses;
    }

    private Integer findNext() {
        Integer zeroPrev = null;
        for (int i = 0; i < numCourses; i++) {
            if (prevs[i] != null && prevs[i].size() == 0) {
                zeroPrev = i;
                break;
            }
        }
        return zeroPrev;
    }
}