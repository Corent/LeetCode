package com.sven.shangtang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(3);
            list.add(0, sc.nextInt());
            list.add(1, sc.nextInt());
            list.add(2, sc.nextInt());
            lists.add(list);
        }
        sc.close();
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(2) - o1.get(2);
            }
        });
        int ans = 0;
        while (lists.size() > 1) {
            List<Integer> l1 = lists.get(lists.size() - 1);
            List<Integer> l2 = lists.get(lists.size() - 2);
            List<Integer> l3 = new ArrayList<>(3);
            if (l1.get(2) > l2.get(2)) {
                l3.add(0, l1.get(0));
                l3.add(1, l1.get(1));
                l3.add(2, l1.get(2) + l2.get(2));
                ans += (Math.abs(l1.get(0) - l2.get(0)) + Math.abs(l1.get(1) - l2.get(1))) * l2.get(2);
            } else {
                l3.add(0, l2.get(0));
                l3.add(1, l2.get(1));
                l3.add(2, l1.get(2) + l2.get(2));
                ans += (Math.abs(l1.get(0) - l2.get(0)) + Math.abs(l1.get(1) - l2.get(1))) * l1.get(2);
            }
            lists.remove(lists.size() - 1);
            lists.remove(lists.size() - 1);
            lists.add(l3);
            for (int i = lists.size() - 1; i > 0; i--) {
                if (i > 0) {
                    List<Integer> tmp = lists.get(i);
                    List<Integer> tmp1 = lists.get(i - 1);
                    if (tmp.get(2) > tmp1.get(2)) {
                        lists.set(i, tmp1);
                        lists.set(i - 1, tmp);
                    } else break;
                }
            }
        }
        System.out.println(ans);
    }

    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        int idx = chs.length - 2;

        while (idx >= 0) {
            if (chs[idx] >= chs[idx + 1]) {
                idx--;
            } else break;
        }

        if (idx == -1) return -1;
        int i = chs.length - 1;
        while (chs[i] <= chs[idx]) i--;
        char c = chs[i];
        chs[i] = chs[idx];
        chs[idx] = c;
        Arrays.sort(chs, idx + 1, chs.length);

        Long ans = Long.valueOf(new String(chs));
        return ans > Integer.MAX_VALUE ? -1: ans.intValue();
    }
}
