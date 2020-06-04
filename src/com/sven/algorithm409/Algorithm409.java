package com.sven.algorithm409;

import java.util.PriorityQueue;

public class Algorithm409 {
}

class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int cnt: hash) {
            if (cnt > 0) {
                queue.add(cnt);
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            if (queue.peek() > 1) {
                int cnt = queue.poll();
                ans += cnt;
                if ((cnt & 1) != 0) {
                    ans--;
                    queue.add(1);
                }
            } else {
                ans++;
                break;
            }
        }
        return ans;
    }
}

class Solution2 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        int ans = 0;
        boolean hasSingle = false;
        for (int cnt: hash) {
            if (cnt > 0) {
                if (cnt > 1) {
                    ans += cnt;
                    if ((cnt & 1) != 0) {
                        ans--;
                        hasSingle = true;
                    }
                } else hasSingle = true;
            }
        }

        return hasSingle ? ans + 1 : ans;
    }
}