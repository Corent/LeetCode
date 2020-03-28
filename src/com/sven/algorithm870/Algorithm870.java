package com.sven.algorithm870;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Algorithm870 {
}

class Solution {

    private List<Integer> list = new LinkedList<>();

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        for (int a: A) list.add(a);
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            ans[i] = findLarger(B[i]);
        }
        return ans;
    }

    private int findLarger(int b) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (a > b) {
                it.remove();
                return a;
            }
        }
        it = list.iterator();
        int a = it.next();
        it.remove();
        return a;
    }
}