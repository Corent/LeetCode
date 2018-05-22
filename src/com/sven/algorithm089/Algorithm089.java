package com.sven.algorithm089;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm089 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.func(7));
    }
}

/**
 * https://www.cnblogs.com/grandyang/p/4315649.html
 */
class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n < 0) return ans;
        ans.add(0);
        int cnt = Double.valueOf(Math.pow(2, n)).intValue();
        while (ans.size() < cnt) {
            int s = ans.size();
            int m = ans.get(s - 1);
            ans.add(func(m, (s & 1) != 0? 0: func(m) + 1));
        }
        return ans;
    }

    //改变某一位
    private int func(int m, int k) {
        return m ^ (1 << k);
    }

    //右起第一个为1的位元
    public int func(int m) {
        int i = -1;
        while ((m & 1) == 0) {
            i++;
            m >>= 1;
        }
        return i + 1;
    }
}