package com.sven.algorithm263;

public class Algorithm263 {

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(-1000));
    }
}

class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while ((num & 1) == 0) num >>= 1;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}