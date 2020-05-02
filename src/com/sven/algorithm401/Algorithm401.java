package com.sven.algorithm401;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm401 {
}

class Solution {

    private Map<Integer, List<Integer>> map1 = new HashMap<>();
    private Map<Integer, List<Integer>> map2 = new HashMap<>();

    public List<String> readBinaryWatch(int num) {

        initMap(12, map1);
        initMap(60, map2);

        List<String> ans = new ArrayList<>();
        int max1 = 3, max2 = 5;
        if (num > max1 + max2) return ans;
        for (int i = 0; i <= Math.min(max1, num); i++) {
            int j = num - i;
            if (j > max2) continue;
            List<Integer> hours = map1.get(i);
            List<Integer> minutes = map2.get(j);
            if (hours == null || minutes == null) continue;
            for (Integer hour: hours) {
                for (Integer minute: minutes) {
                    ans.add(hour + ":" + ((minute < 10 ? "0" : "") + minute));
                }
            }
        }
        return ans;
    }

    private void initMap(int n, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < n; i++) {
            int cnt = countBits(i);
            List<Integer> list = map.containsKey(cnt) ? map.get(cnt) : new ArrayList<>();
            list.add(i);
            map.put(cnt, list);
        }
    }

    private int countBits(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }
}