package com.sven.algorithm381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Algorithm381 {
}

class RandomizedCollection {

    private Random random;
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        random = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean alreadyExist = map.containsKey(val);
        Set<Integer> set = alreadyExist ? map.get(val) : new HashSet<>();
        list.add(val);
        set.add(list.size() - 1);
        map.put(val, set);
        return !alreadyExist;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> set = map.get(val);
        Iterator<Integer> it = set.iterator();
        int idx = it.next();
        if (!it.hasNext()) map.remove(val);
        else it.remove();
        if (idx != list.size() - 1) {
            int tail = list.get(list.size() - 1);
            list.set(idx, tail);
            Set<Integer> tailIdxSet = map.get(tail);
            tailIdxSet.remove(list.size() - 1);
            tailIdxSet.add(idx);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */