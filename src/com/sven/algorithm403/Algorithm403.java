package com.sven.algorithm403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Algorithm403 {
}

class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone: stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(stones[0]).add(0);
        for (int stone: stones) {
            for (int lastStep: map.get(stone)) {
                for (int nextSetp = lastStep - 1; nextSetp <= lastStep + 1; nextSetp++) {
                    if (nextSetp > 0 && map.containsKey(stone + nextSetp)) {
                        map.get(stone + nextSetp).add(nextSetp);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}