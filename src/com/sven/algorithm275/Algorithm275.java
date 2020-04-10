package com.sven.algorithm275;

public class Algorithm275 {

    public static void main(String[] args) {

    }
}

/**
 * https://www.cnblogs.com/liujinhong/p/6482479.html
 */
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= len - mid) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;  // left = mid = right
    }
}