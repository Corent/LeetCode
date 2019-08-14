package com.sven.algorithm278;

public class Algorithm278 {
}


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

abstract class VersionControl {

    boolean isBadVersion(int version) {
        return true;
    }
}

class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        if (n <= 0) return 0;
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}