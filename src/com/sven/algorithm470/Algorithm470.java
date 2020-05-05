package com.sven.algorithm470;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Algorithm470 {
}

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

class SolBase {
    
    protected int rand7(){
        return 0;
    }
}

class Solution extends SolBase {
    
    //  这10个数概率都是 2/49，其他组合都不一样
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
        put(2, 1);
        put(3, 2);
        put(5, 3);
        put(8, 4);
        put(10, 5);
        put(15, 6);
        put(18, 7);
        put(20, 8);
        put(24, 9);
        put(30, 10);
    }};
    
    public int rand10() {
        int n = (rand7() - 1) * (rand7() - 1);  // [0 - 6] * [0 - 6]
        while (!map.containsKey(n)) n = rand7() * rand7();
        return map.get(n);
    }
}