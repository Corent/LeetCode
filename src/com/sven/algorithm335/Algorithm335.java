package com.sven.algorithm335;

public class Algorithm335 {
}

/**
 * https://blog.csdn.net/zmq570235977/article/details/51705518
 */
class Solution {
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            if (i > 3 && x[i - 1] == x[i - 3] && x[i - 2] <= x[i] + x[i - 4]) return true;
            if (i > 4 && x[i - 1] <= x[i - 3] && x[i - 4] <= x[i - 2] && x[i - 2] <= x[i] + x[i - 4] && x[i - 3] <= x[i - 1] + x[i - 5]) return true;
        }
        return false;
    }
}