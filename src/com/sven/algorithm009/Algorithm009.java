package com.sven.algorithm009;

public class Algorithm009 {
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        else if (x < 10) return true;

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        if (x == reverse || x == reverse / 10) return true;
        return false;
    }
}