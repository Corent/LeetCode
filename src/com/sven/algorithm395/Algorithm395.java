package com.sven.algorithm395;

public class Algorithm395 {
}

/**
 * https://blog.csdn.net/dezhonger/article/details/104226299
 */
class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0, len = s.length();
        char[] ch = s.toCharArray();
        for (int unique = 0; unique < 26; unique++) {   //  不同的字符个数最多有26
            int a = 0; //当前窗口有多少个不同的字母
            int b = 0; //当前窗口有多少字母的次数是 >= k 的
            int[] cnt = new int[26];

            for (int left = 0, right = 0; right < len; right++) {
                int letter = ch[right] - 'a';
                if (cnt[letter] == 0) a++; //新的字母
                if (++cnt[letter] == k) b++;

                if (a > unique) {
                    while (left < right) {
                        cnt[ch[left] - 'a']--;
                        if (cnt[ch[left] - 'a'] == 0) a--;
                        if (cnt[ch[left] - 'a'] == k - 1) b--;
                        left++;
                        if (a == unique) break;
                    }
                }
                //  当前窗口每个字符都出现次数都 >= k
                if (a == unique && b == unique) res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }
}


class Solution2 {

    private String s;
    private int k;

    public int longestSubstring(String s, int k) {
        if (s == null) return 0;
        if (s.length() == 0) return 0;
        if (k <= 1) return s.length();
        this.s = s;
        this.k = k;
        return count(0, s.length() - 1);
    }

    public int count(int left, int right) {
        if (right - left + 1 < k) return 0;
        int[] cnt = new int[26];
        for (int i = left; i <= right; i++) {   //  先统计该区间内所有字符的出现次数
            ++cnt[s.charAt(i) - 'a'];
        }
        // 去除左右两边不满足条件的字符
        while (right - left + 1 >= k && cnt[s.charAt(left) - 'a'] < k) left++;
        while (right - left + 1 >= k && cnt[s.charAt(right) - 'a'] < k) right--;
        if (right - left + 1 < k) return 0;

        // 劈开分治
        for (int i = left; i <= right; i++) {
            // 只需要劈开一次就可以返回了，
            // 因为即使右边还有不满足条件的字符，
            // 也会在其子阶段求解得到了
            if (cnt[s.charAt(i) - 'a'] < k) {
                return Math.max(count(left, i - 1), count(i + 1, right));
            }
        }
        return right - left + 1;
    }
}