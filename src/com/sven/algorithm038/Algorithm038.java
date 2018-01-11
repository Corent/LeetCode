package com.sven.algorithm038;

public class Algorithm038 {

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(5));
    }
}

/**
 * very ez
 */
class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String ans = "1";
        while (n > 1) {
            int cnt = 1;
            char ch = ans.charAt(0);
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < ans.length(); i++) {
                if (ch == ans.charAt(i)) cnt++;
                else {
                    builder.append(cnt).append(ch);
                    ch = ans.charAt(i);
                    cnt = 1;
                }
            }
            builder.append(cnt).append(ch);
            ans = builder.toString();
            n--;
        }
        return ans;
    }
}