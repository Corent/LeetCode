package com.sven.algorithm1360;

public class algorithm1360 {
}

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(dateToInt(date1) - dateToInt(date2));
    }

    private int dateToInt(String date) {
        String[] ss = date.split("-");
        if (ss.length != 3) {
            return 0;
        }
        int year = Integer.valueOf(ss[0]), month = Integer.valueOf(ss[1]), day = Integer.valueOf(ss[2]);
        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int rst = day - 1;
        while (month != 0) {
            rst += months[--month];
            if (month == 2 && isLeapYear(year)) {
                rst += 1;
            }
        }
        rst += 365 * (year - 1971);
        rst += (year - 1) / 4 - 1971 / 4;
        rst -= (year - 1) / 100 - 1971 / 100;
        rst += (year - 1) / 400 - 1971 / 400;
        return rst;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }
}