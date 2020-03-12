package com.sven.algorithm1044;

import java.util.Arrays;
import java.util.HashSet;

public class Algorithm1044 {
}

/**
 * https://blog.csdn.net/qq_34826261/article/details/97319790
 *
 * 方法1：后缀数组法
 * 方法2：字符串编码法
 * 方法3：二分查找+字符串编码法
 */

class Solution1 {   // Memory Limit Exceeded!!! WTF
    public String longestDupSubstring(String S) {
        if (S == null) return null;
        int n = S.length(), maxLen = 0;
        if (n == 1) return "";
        String[] strs = new String[S.length()];
        for (int i = 0; i < n; i++) {
            strs[i] = S.substring(i);
        }
        String ans = "";
        Arrays.sort(strs);
        for (int i = 0; i < n - 1; i++) {
            String commonSuffix = longestCommonSuffix(strs[i], strs[i + 1]);
            if (commonSuffix.length() > maxLen) {
                maxLen = commonSuffix.length();
                ans = commonSuffix;
            }
        }
        return ans;
    }

    private String longestCommonSuffix(String s1, String s2) {
        int idx = 0, n = Math.min(s1.length(), s2.length());
        while (idx < n && s1.charAt(idx) == s2.charAt(idx)) {
            idx++;
        }
        return s1.substring(0, idx);
    }
}

class Solution3 {

    private int n;
    private int base = 26;  // 26进制
    private int[] nums;
    private long module = Double.valueOf(Math.pow(2, 32)).longValue();  // 取一个足够大的数，用以取模

    public String longestDupSubstring(String S) {
        n = S.length();
        if (n <= 1) return "";
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = S.charAt(i) - 'a';  // 只考虑小写字母
        }
        int low = 1, high = n;
        while (low != high) {
            int L = (high - low) / 2 + low;
            if (search(L) != -1)
                low = L + 1;
            else
                high = L;
        }
        int start = search(low - 1);
        return start == -1 ? "" : S.substring(start, start + low - 1);
    }

    // 返回重复字符串的起始位置
    // 参数：L-重复字符串的长度，base-进制，module-取模数，nums-字符串的编码数组
    public int search(int L) {
        HashSet<Long> hashSet = new HashSet<>();
        long tmp = 0, baseL = 1;    // baseL 是最高位对应的base
        for (int j = 0; j < L; j++) {
            tmp = (tmp * base + nums[j]) % module;  // 防止溢出
            //System.out.println(tmp);
            baseL = (baseL * base) % module;
        }
        hashSet.add(tmp);
        for (int j = 1; j <= n - L; j++) {  // 长度为L的窗口
            tmp = (tmp * base - nums[j - 1] * baseL % module + module) % module;  // 去掉前一位
            tmp = (tmp + nums[j + L - 1]) % module; // 加上最后一位
            if (hashSet.contains(tmp)) return j;
            hashSet.add(tmp);
        }
        return -1;
    }
}