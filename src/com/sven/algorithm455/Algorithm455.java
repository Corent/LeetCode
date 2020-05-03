package com.sven.algorithm455;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm455 {

    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[] { 10, 9, 8, 7 }, new int[] { 5, 6, 7, 8 }));
    }
}

class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        List<Integer> list = Arrays.stream(s).boxed().collect(Collectors.toList());
        int ans = 0;
        for (int i: g) {
            Integer idx = find(i, list);
            if (idx != null) {
                ans++;
                list.remove(idx.intValue());
            }
        }
        return ans;
    }

    private Integer find(int g, List<Integer> list) {
        int left = 0, right = list.size() - 1;
        if (list.size() == 0 || g > list.get(right)) return null;
        if (g <= list.get(left)) return 0;
        while (left < right) {
            int mid = (left + right) >> 1, n = list.get(mid);
            if (n == g) return mid;
            if (n > g) right = mid;
            else left = mid + 1;
        }
        return list.get(left) >= g ? left : null;
    }
}

class Solution2 {

    public int findContentChildren(int[] g, int[] s) {

        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0,j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else j++;
        }

        return count;
    }
}