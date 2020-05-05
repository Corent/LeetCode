package com.sven.algorithm564;

import java.util.HashSet;
import java.util.Set;

public class Algorithm564 {
}

/**
 * https://blog.csdn.net/magicbean2/article/details/78889530
 * https://blog.csdn.net/u013554860/article/details/82431617
 */
class Solution {

    public String nearestPalindromic(String n) {
        int len = n.length();
        Set<Long> candidates = new HashSet<>();
        candidates.add(Double.valueOf(Math.pow(10, len)).longValue() + 1);
        candidates.add(Double.valueOf(Math.pow(10, len - 1)).longValue() - 1);
        long prefix = Long.valueOf(n.substring(0, (len + 1) >> 1)), minDiff = Long.MAX_VALUE, num = Long.valueOf(n), ans = Long.MAX_VALUE;
        for (int i = -1; i <= 1; i++) {
            String p = String.valueOf(prefix + i);
            StringBuilder builder = new StringBuilder();
            String pp = p + builder.append((len & 1) == 0 ? p : p.substring(0, p.length() - 1)).reverse().toString();
            candidates.add(Long.valueOf(pp));
        }
        candidates.remove(num);
        for (Long c: candidates) {
            long diff = Math.abs(c - num);
            if (diff < minDiff) {
                minDiff = diff;
                ans = c;
            } else if (diff == minDiff) {
                ans = Math.min(ans, c);
            }
        }
        return String.valueOf(ans);
    }
}