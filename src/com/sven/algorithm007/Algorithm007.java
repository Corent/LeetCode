package com.sven.algorithm007;

public class Algorithm007 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-2147483648));
    }
}

/**
 * 转为String处理，注意溢出 No
 *
 * https://blog.csdn.net/qq_33168253/article/details/79721612
 */
class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        Long tmp = Math.abs(Long.valueOf(x));
        tmp = Long.valueOf(new StringBuilder(String.valueOf(tmp)).reverse().toString());
        if (isNegative && tmp > Math.abs(Integer.MAX_VALUE) || !isNegative && tmp > Integer.MAX_VALUE) return 0;
        return tmp.intValue() * (isNegative? -1: 1);
    }
}

class Solution2 {
    public int reverse(int x) {
        int[] a = new int[100];
        int n = 0;
        Boolean flag = null;
        if(x >= 0) flag = true;
        else {
            flag = false;
            x = -x;
        }
        while (x != 0) {
            a[n++] = x % 10;
            x = x / 10;
        }

        int ans = 0, t = 0;
        for (int i = 0 ; i < n ; i ++) {
            t = ans;
            ans = t*10 + a[i];
            if (t != ans / 10) return 0;
        }
        if (!flag) ans = -ans;
        return ans;
    }
}