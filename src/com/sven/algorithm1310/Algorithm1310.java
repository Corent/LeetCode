package com.sven.algorithm1310;

public class Algorithm1310 {
}

class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xors = new int[arr.length], ans = new int[queries.length];
        xors[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xors[i] = arr[i] ^ xors[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = queries[i][0] == 0? xors[queries[i][1]] : xors[queries[i][1]] ^ xors[queries[i][0] - 1];
        }
        return ans;
    }
}