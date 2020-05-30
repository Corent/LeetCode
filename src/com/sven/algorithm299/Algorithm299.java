package com.sven.algorithm299;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Algorithm299 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHint("1123", "0111"));   // 1A1B
        System.out.println(solution.getHint("1122", "2211"));   // 0A4B
        System.out.println(solution.getHint("1122", "1222"));   // 3A0B
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) return null;
        if (secret.equals("") || guess.equals("")) return "0A0B";
        int n = secret.length(), aCnt = 0, bCnt = 0;
        Character[] secretNums = new Character[n], guessNums = new Character[n];
        for (int i = 0; i < n; i++) {
            char sChar = secret.charAt(i), gChar = guess.charAt(i);
            if (sChar == gChar) aCnt++;
            else {
                secretNums[i] = sChar;
                guessNums[i] = gChar;
            }
        }
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (guessNums[i] != null) {
                LinkedList<Integer> list = map.containsKey(guessNums[i])? map.get(guessNums[i]): new LinkedList<>();
                list.addLast(i);
                map.put(guessNums[i], list);
            }
        }
        for (int i = 0; i < n; i++) {
            if (secretNums[i] != null) {
                if (map.containsKey(secretNums[i])) {
                    LinkedList<Integer> list = map.get(secretNums[i]);
                    if (!list.isEmpty()) {
                        bCnt++;
                        list.pollFirst();
                    }
                }
            }
        }
        return aCnt + "A" + bCnt + "B";
    }
}

/**
 * Better solution
 * https://blog.csdn.net/sinat_41917109/article/details/88855983
 */
class Solution2 {

    public String getHint(String secret, String guess) {
        int aCnt = 0, bCnt = 0, n = secret.length();
        int[] ds = new int[10], dg = new int[10];
        for (int i = 0; i < n; i++) {
            int x = secret.charAt(i) - '0', y = guess.charAt(i) - '0';
            if (x == y) aCnt++;
            ds[x]++;
            dg[y]++;
        }
        for (int i = 0; i < 10; i++) bCnt += Math.min(ds[i], dg[i]);
        return aCnt + "A" + (bCnt - aCnt) + "B";
    }
}