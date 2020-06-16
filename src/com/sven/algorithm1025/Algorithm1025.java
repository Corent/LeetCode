package com.sven.algorithm1025;

import java.util.HashMap;
import java.util.Map;

public class Algorithm1025 {
}

class Solution {

    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}

class Solution2 {

    public boolean divisorGame(int N) {
        if (N == 1) return false;
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            dp[i] = false;
            for (int x = 1; x <= i / 2; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}

class Solution3 {

    private Map<Integer, Boolean> map = new HashMap<Integer, Boolean>() {{
        put(1, false);
    }};

    public boolean divisorGame(int N) {
        if (map.containsKey(N)) return map.get(N);
        for (int x = 1; x <= N / 2; x++) {
            if (N % x == 0 && !divisorGame(N - x)) {
                map.put(N, true);
                return true;
            }
        }
        map.put(N, false);
        return false;
    }
}