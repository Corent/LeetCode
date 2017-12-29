package com.sven.algorithm012;

public class Algorithm012 {
}

/**
 * 数字除以10，判断当前数量级的数字所对应的字符串，拼接的时候注意低位在左边
 */
class Solution {

    private static String[][] roman = {
        { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
        { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
        { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
        { "", "M", "MM", "MMM" }
    };

    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            builder.insert(0, roman[digit][remain]);
            digit++;
            num /= 10;
        }
        return builder.toString();
    }
}