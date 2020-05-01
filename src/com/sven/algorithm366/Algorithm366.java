package com.sven.algorithm366;

public class Algorithm366 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(16));
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        long left = 0, right = num;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long n = mid * mid;
            if (n == num) return true;
            if (n > num) right = mid - 1;
            else left = mid + 1;
        }
        return left * left == num;
    }
}