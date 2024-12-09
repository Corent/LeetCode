package com.sven.algorithm1238;

import java.util.ArrayList;
import java.util.List;

public class algorithm1238 {
}

class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            rst.add((i >> 1) ^ i ^ start);
        }
        return rst;
    }
}