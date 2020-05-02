package com.sven.algorithm420;

import java.util.ArrayList;
import java.util.List;

public class Algorithm420 {
}

/**
 * https://blog.csdn.net/u013554860/article/details/81518782
 */
class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        boolean lowercase = false, uppercase = false, digit = false;
        for (int i = 0; i < n; i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') digit = true;
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') lowercase = true;
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') uppercase = true;
            int j = i;
            while (i < n - 1 && s.charAt(j) == s.charAt(i + 1)) i++;
            list.add(i - j + 1);
        }
        int add = (digit ? 0 : 1) + (lowercase ? 0 : 1) + (uppercase ? 0 : 1);
        int ans = 0;
        if (n < 6) {
            ans = 6 - n;
            if (add > ans) ans += add - ans;
        } else {
            int haveToDelete = (n > 20 ? n - 20 : 0);
            ans += haveToDelete;
            int m = list.size();
            for (int i = 0; i < m; i++) {
                if (list.get(i) >= 3) {
                    if (list.get(i) % 3 == 0 && haveToDelete > 0) {
                        haveToDelete -= 1;
                        list.set(i, list.get(i) - 1);
                    } else {
                        if (list.get(i) % 3 == 1 && haveToDelete > 1) {
                            haveToDelete -= 2;
                            list.set(i, list.get(i) - 2);
                        }
                    }
                }
            }
            int changeCnt = 0;
            for (int i = 0; i < m; i++) {
                if (list.get(i) >= 3 && haveToDelete > 0) {
                    int needToDelete = list.get(i) - 2;
                    if (needToDelete <= haveToDelete) {
                        haveToDelete -= needToDelete;
                        list.set(i, 2);
                    } else {
                        list.set(i, list.get(i) - haveToDelete);
                        haveToDelete = 0;
                    }
                }
                changeCnt += list.get(i) / 3;
            }
            ans += Math.max(changeCnt, add);
        }
        return ans;
    }
}