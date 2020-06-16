package com.sven.algorithm1184;

public class Algorithm1184 {

    public static void main(String[] args) {
        System.out.println(new Solution().distanceBetweenBusStops(new int[]{ 7, 10, 1, 12, 11, 14, 5, 0 }, 0, 3));
    }
}

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        if (destination > start) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        int[] sums = new int[distance.length];
        for (int i = 0; i < distance.length; i++) {
            sums[i] = i == 0 ? distance[i] : distance[i] + distance[i - 1];
        }
        int pathLen1 = sums[destination - 1] - sums[start] + distance[start];
        int pathLen2 = sums[sums.length - 1] - pathLen1;
        return Math.min(pathLen1, pathLen2);
    }
}