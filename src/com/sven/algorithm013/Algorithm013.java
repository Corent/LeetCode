package com.sven.algorithm013;

import java.util.HashMap;
import java.util.Map;

public class Algorithm013 {
}

/**
 * map字符与值的映射，遍历累加时注意遇到当前位置比先前位置字符所表示的数字大的情况
 */
class Solution {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('i', 1);
        put('V', 5);
        put('v', 5);
        put('X', 10);
        put('x', 10);
        put('L', 50);
        put('l', 50);
        put('C', 100);
        put('c', 100);
        put('D', 500);
        put('d', 500);
        put('M', 1000);
        put('m', 1000);
    }};

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int pre = map.get(s.charAt(i - 1)), now = map.get(s.charAt(i));
            if (pre < now) ans += now - pre * 2; // - pre + now - pre
            else ans += now;
        }
        return ans;
    }
}