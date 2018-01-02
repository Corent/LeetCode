package com.sven.algorithm017;

import java.util.ArrayList;
import java.util.List;

public class Algorithm017 {

    public static void main(String[] args) {
        List<String> ans = new Solution().letterCombinations("23");
        ans.forEach(System.out::println);
    }
}

/**
 * 递归回溯，ez
 */
class Solution {

    private String digits;
    private List<String> ans = new ArrayList<>();

    private static Character[][] chs = new Character[][] {
            {},                     //0
            {},                     //1
            { 'a', 'b', 'c' },      //2
            { 'd', 'e', 'f' },      //3
            { 'g', 'h', 'i' },      //4
            { 'j', 'k', 'l' },      //5
            { 'm', 'n', 'o' },      //6
            { 'p', 'q', 'r', 's' }, //7
            { 't', 'u', 'v' },      //8
            { 'w', 'x', 'y', 'z' }  //9
    };

    public List<String> letterCombinations(String digits) {
        this.digits = digits.replace("0", "").replace("1", "");  //剔除0、1
        if (this.digits.length() == 0) return ans;
        char[] ch = new char[digits.length()];
        core(ch, 0);
        return ans;
    }

    private void core(char[] ch, int idx) {
        if (idx == ch.length) {
            ans.add(new String(ch));
            return;
        }

        Character[] row = chs[digits.charAt(idx) - '0'];
        for (int i = 0; i < row.length; i++) {
            ch[idx] = row[i];
            core(ch, idx + 1);
        }
    }
}