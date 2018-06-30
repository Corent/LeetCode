package com.sven.algorithm241;

import java.util.ArrayList;
import java.util.List;

public class Algorithm241 {
}

/**
 * 方法同Algorithm095
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 */

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.length() == 0) return ans;
        for (int i = 0, n = input.length(); i < n; i++) {
            char ch = input.charAt(i);
            if (ch != '+' && ch != '-' && ch != '*') continue;
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (int j = 0, nLeft = left.size(); j < nLeft; j++) {
                for (int k = 0, nRight = right.size(); k < nRight; k++) {
                    switch (ch) {
                        case '+':
                            ans.add(left.get(j) + right.get(k));
                            break;
                        case '-':
                            ans.add(left.get(j) - right.get(k));
                            break;
                        case '*':
                            ans.add(left.get(j) * right.get(k));
                            break;
                        default: break;
                    }
                }
            }
        }
        if (ans.isEmpty()) ans.add(Integer.valueOf(input));
        return ans;
    }
}
