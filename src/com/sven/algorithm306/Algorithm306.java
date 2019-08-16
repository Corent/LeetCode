package com.sven.algorithm306;

public class Algorithm306 {

    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("000"));
    }
}

/**
 * 确定了前两个数，后面是哪些数也就确定了
 */
class Solution {

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        int n = num.length();
        for (int i = 1; i < n - 1; i++) {   // i 是第二个数起始位置
            String subA = num.substring(0, i);  // 第一个数
            Long a = convertStringToLong(subA);
            if (a == null) continue;
            for (int j = i + 1; j < n; j++) {   // j 是第三个数起始位置
                String subB = num.substring(i, j);  // 第二个数
                Long b = convertStringToLong(subB);
                if (b == null) continue;
                if (check(a, b, num.substring(j))) return true;
            }
        }
        return false;
    }

    private Long convertStringToLong(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.length() > 1 && s.charAt(0)== '0') return null;
        return Long.valueOf(s);
    }

    private boolean check(long a, long b, String s) {
        long num1 = new Long(a), num2 = new Long(b);
        long next = num1 + num2;
        String nextNums = new String(s), nextNum = String.valueOf(next);
        while (nextNums.startsWith(nextNum)) {
            nextNums = nextNums.substring(nextNum.length());
            num1 = num2;
            num2 = next;
            next = num1 + num2;
            nextNum = String.valueOf(next);
        }
        return nextNums.length() == 0;
    }
}