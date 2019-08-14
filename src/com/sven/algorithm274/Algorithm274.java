package com.sven.algorithm274;

import java.util.Arrays;

public class Algorithm274 {

    public static void main(String[] args) {

    }
}

/**
 * https://blog.csdn.net/fuqiuai/article/details/83350009
 */
class Solution {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] <= hIndex) return hIndex;
            hIndex++;
        }
        return hIndex;
    }
}