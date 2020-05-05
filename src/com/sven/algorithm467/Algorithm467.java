package com.sven.algorithm467;

import java.util.Arrays;

public class Algorithm467 {
}

/**
 * https://blog.csdn.net/kexinxin1/article/details/93016270
 * https://blog.csdn.net/qq_38595487/article/details/83239404
 */
class Solution {

    public int findSubstringInWraproundString(String p) {
        int[] pSize = new int[p.length()];
        int[] count = new int[26];  //  以该字符结尾的字串的个数
        for (int i = 0; i < p.length() ; i ++) {
            pSize[i] = p.charAt(i) - 'a';
        }
        int num = 0;
        for (int i = 0; i < pSize.length; i ++) {
            num = i > 0 && (pSize[i - 1] + 1) % 26 == pSize[i] ? num + 1 : 1;
            count[pSize[i]] = Math.max(count[pSize[i]], num);
        }
        return Arrays.stream(count).sum();
    }
}
