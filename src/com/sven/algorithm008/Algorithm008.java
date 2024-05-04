package com.sven.algorithm008;

public class Algorithm008 {
}

/**
 * 步骤如下：
 * 1. 跳过所有空字符
 * 2. 判断正负号，并跳过
 * 3. 从左到右遍历，累加，注意判断溢出
 * 4. 带上正负号返回
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) return 0;
		char[] ch = str.toCharArray();
        int length = str.length();
        int sign = 1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (ch[i] == ' ' || ch[i] == 0x9) start++;
            else break;
        }
        if (ch[start] == '-') {
            sign = -1;
            start++;
        } else if (ch[start] == '+') {
            sign = 1;
            start++;
        }
        int result = 0;
        for (int i = start; i < length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                int digit = ch[i] - '0';
                if (Integer.MAX_VALUE / 10 >= result)
                    result *= 10;
                else
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

                if (Integer.MAX_VALUE - digit >= result)
                    result += digit;
                else
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                break;
            }
        }
        return sign * result;
    }
}