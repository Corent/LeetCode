package com.sven.algorithm916;

import java.util.ArrayList;
import java.util.List;

public class Algorithm916 {
}

class Solution {

    public List<String> wordSubsets(String[] A, String[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int[] BHash = new int[26];
        for (int i = 0; i < B.length; i++) {
            int[] BHashsTmp = new int[26];
            for (int j = 0; j < B[i].length(); j++) {
                BHashsTmp[B[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                BHash[j] = Math.max(BHash[j], BHashsTmp[j]);    //  Important!!!
            }
        }
        for (int i = 0; i < A.length; i++) {
            int[] AHash = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                AHash[A[i].charAt(j) - 'a']++;
            }
            int idx = 0;
            while (idx < 26) {
                if (AHash[idx] < BHash[idx]) break;
                idx++;
            }
            if (idx == 26) ans.add(A[i]);
        }
        return ans;
    }
}