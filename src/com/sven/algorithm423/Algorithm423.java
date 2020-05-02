package com.sven.algorithm423;

public class Algorithm423 {
}

/**
 * https://blog.csdn.net/camellhf/article/details/52922763
 */
class Solution {
    public String originalDigits(String s) {
        int[] letters = new int[26];
        int[] numbers = new int[10];

        for (int i = 0; i < s.length(); i++) letters[s.charAt(i) - 'a']++;

        numbers[8] = letters['g' - 'a'];
        numbers[6] = letters['x' - 'a'];
        numbers[4] = letters['u' - 'a'];
        numbers[2] = letters['w' - 'a'];
        numbers[0] = letters['z' - 'a'];
        numbers[5] = letters['f' - 'a'] - numbers[4];
        numbers[3] = letters['h' - 'a'] - numbers[8];
        numbers[7] = letters['s' - 'a'] - numbers[6];
        numbers[1] = letters['o' - 'a'] - numbers[0] - numbers[2] - numbers[4];
        numbers[9] = letters['i' - 'a'] - numbers[5] - numbers[6] - numbers[8];

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            while (numbers[i] > 0) {
                builder.append(i);
                numbers[i]--;
            }
        }

        return builder.toString();
    }
}