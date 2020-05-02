package com.sven.algorithm406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class algorithm406 {
}

/**
 * https://blog.csdn.net/weixin_37373020/article/details/81000845
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        for (int[] p: people) {
            list.add(p[1], p);
        }
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}