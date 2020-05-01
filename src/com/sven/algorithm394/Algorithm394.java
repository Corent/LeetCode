package com.sven.algorithm394;

import java.util.LinkedList;

public class Algorithm394 {

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                list.addLast(ch);
                continue;
            }
            String tmpStr = "";
            char c = list.pollLast();
            while (c != '[') {
                tmpStr = c + tmpStr;
                c = list.pollLast();
            }

            String tmpInt = "";
            c = list.peekLast();
            while (c >= '0' && c <= '9') {
                tmpInt = c + tmpInt;
                list.pollLast();
                if (list.isEmpty()) break;
                c = list.peekLast();
            }

            int cnt = Integer.valueOf(tmpInt);
            while (cnt > 0) {
                for (int j = 0; j < tmpStr.length(); j++) list.addLast(tmpStr.charAt(j));
                cnt--;
            }
        }

        return list.stream().map(String::valueOf).reduce("", (a, b) -> a + b);
    }
}