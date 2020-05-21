package com.sven.algorithm1154;

public class Algorithm1154 {
}

class Solution {

    private int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7)) - 2;
        int day = Integer.valueOf(date.substring(8));
        if (year % 1000 == 0 || year % 100 != 0 && year % 4 == 0) days[1]++;
        int ans = 0;
        while (month >= 0) {
            ans += days[month--];
        }
        return ans + day;
    }
}