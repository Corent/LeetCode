package com.sven.algorithm475;

import java.util.Arrays;

public class Algorithm475 {
}

/**
 * https://blog.csdn.net/wlsk801/article/details/70306673
 */
class Solution1 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int i = 0;
            // heaters[i + 1] - house < house - heaters[i]
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] < house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}

class Solution2 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = -1;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int distL = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int distR = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            res = Math.max(res, Math.min(distL, distR));
        }
        return res;
    }
}