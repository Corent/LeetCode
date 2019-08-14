package com.sven.amazon.amazon02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {

    public static void main(String[] args) {

    }
}

class Pair {
    public int s;
    public int e;

    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

class Solution {

    public List<Integer> function(Pair[] pairs) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (Pair pair: pairs) {
            min = Math.min(min, pair.s);
            max = Math.max(max, pair.e);
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            int tmp1 = 0;
            for (Pair pair: pairs) {
                if (i >= pair.s && i <= pair.e )
                    tmp1++;
            }
            if (tmp1 > tmp) {
                tmp = tmp1;
                list.clear();
                list.add(i);
            } else if (tmp1 > tmp) {
                list.add(i);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == tmp)
                list.add(entry.getKey());
        }

        return list;
    }
}