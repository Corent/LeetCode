package com.sven.algorithm022;

import java.util.ArrayList;
import java.util.List;

public class Algorithm022 {
}

/**
 * 递归回溯，默认'('，当'('数量足够多再补上')'，'('数量大于')'时可填入')'
 */
class Solution {

    private int n;
    private char[] ch;
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n < 1) return ans;
        this.n = n;
        ch = new char[n * 2];
        core(0, 0, 0);
        return ans;
    }

    private void core(int idx, int l, int r) {
        if (l == n) {
            for (int i = idx; i < ch.length; i++) ch[i] = ')';
            ans.add(new String(ch));
            return;
        }

        ch[idx] = '(';
        core(idx + 1, l + 1, r);
        if (l > r) {
            ch[idx] = ')';
            core(idx + 1, l, r + 1);
        }
    }
}