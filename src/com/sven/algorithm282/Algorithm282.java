package com.sven.algorithm282;

import java.util.LinkedList;
import java.util.List;

public class Algorithm282 {

    public static void main(String[] args) {
        System.out.println(new Solution().addOperators("123", 6));
    }
}

/**
 * DFS
 * https://blog.csdn.net/sunyangwei1993/article/details/52199417
 */
class Solution {

    private int target;
    private List<String> ans = new LinkedList<>();

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) return ans;
        this.target = target;
        addOperators(num, "", 0, 0);
        return ans;
    }

    public void addOperators(String num, String tmp, long curRes, long prevNum) {
        if (curRes == target && num.length() == 0) {
            ans.add(new String(tmp));
            return;
        }

        for (int i = 1; i <= num.length(); i++) {
            String curStr =  num.substring(0, i);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                return;
            }
            long curNum = Long.valueOf(curStr);
            String next = num.substring(i);
            if (tmp.length() != 0) {    //  不是第一个数的话
                addOperators(next, tmp + "*" + curNum, (curRes - prevNum) + prevNum * curNum, prevNum * curNum);
                addOperators(next, tmp + "+" + curNum, curRes + curNum, curNum);
                addOperators(next, tmp + "-" + curNum, curRes - curNum, -curNum);
            } else {
                addOperators(next, curStr, curNum, curNum);
            }
        }
    }
}