package com.sven.algorithm219;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/6/12
 */
public class Algorithm219 {
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) return false;
        int len = nums.length;
        if(len <= 1) return false;
        Set<Integer> count = new HashSet<>();

        for(int i = 0; i < len; i++){
            if (i > k) count.remove(nums[i-k-1]);   //  移除K距离之前不可能的点
            if (!count.add(nums[i])) return true;   //  此时count集合中仅有K距离之内的数，如果已存在当前数，则表示存在
        }
        return false;
    }
}