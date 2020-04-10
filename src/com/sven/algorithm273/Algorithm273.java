package com.sven.algorithm273;

import java.util.HashMap;
import java.util.Map;

public class Algorithm273 {
}

/**
 * https://blog.csdn.net/crazy1235/article/details/52756494
 */
class Solution {

    private String[] units = { "", "Thousand", "Million", "Billion" };

    private Map<Integer, String> words = new HashMap<Integer, String>() {{
        put(0, " ");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
        put(100, "Hundred");
        put(1000, "Thousand");
        put(1000000, "Million");
        put(1000000000, "Billion");
    }};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 > 0) {
                result = helper(num % 1000) + units[i] + getWord(0) + result;
            }
            num /= 1000;
            i++;
        }
        return result.trim();
    }

    public String helper(int num) {
        if (num >= 100) {
            return getWord(num / 100) + getWord(0) + getWord(100) + getWord(0) + helper(num % 100);
        } else if (num > 20) {
            return getWord((num / 10) * 10) + getWord(0) + helper(num % 10);
        } else if (num > 0) {
            return getWord(num) + getWord(0);
        } else if (num == 0) {
            return "";
        }
        return "";
    }

    public String getWord(int num) {
        String word = words.get(num);
        return word != null ? word: " ";
        /*switch (num) {
            case 0:
                return " ";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
            case 100:
                return "Hundred";
            case 1000:
                return "Thousand";
            case 1000000:
                return "Million";
            case 1000000000:
                return "Billion";
            default:
                return " ";
        }*/
    }
}