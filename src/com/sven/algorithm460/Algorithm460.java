package com.sven.algorithm460;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Algorithm460 {
}

/**
 * https://blog.csdn.net/csdnlijingran/article/details/86527646
 */
class LFUCache {

    //保存key，value
    private HashMap<Integer, Integer> vals;
    //保存key对应value的访问次数
    private HashMap<Integer, Integer> counts;
    //保存相同访问次数的key的set集合
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    private int cap;
    //初始化数据出现的频次
    private int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;

        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);

        //判断min要不要加1
        if (count == min && lists.get(count).size() == 0) {
            min++;
        }

        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) return;

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() >= cap) {
            int minFreKey = lists.get(min).iterator().next();
            lists.get(min).remove(minFreKey);
            vals.remove(minFreKey);
            counts.remove(minFreKey);
        }

        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        if (!lists.containsKey(1)) {
            lists.put(1, new LinkedHashSet<>());
        }
        lists.get(1).add(key);
    }
}
