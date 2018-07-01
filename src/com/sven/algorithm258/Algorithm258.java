package com.sven.algorithm258;

public class Algorithm258 {
}

/**
 * 找规律
 * https://www.cnblogs.com/grandyang/p/4741028.html
 */

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}