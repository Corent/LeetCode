package com.sven.algorithm336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Algorithm336 {
}

/**
 * https://www.cnblogs.com/Dylan-Java-NYC/p/6359809.html
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2){
            return ans;
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            hm.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++){
            for (int j = 0; j <= words[i].length(); j++) { //j是能到word[i].length()的
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);

                if (isPalindrome(left)) {
                    String reverseRight = new StringBuilder(right).reverse().toString();
                    if (hm.containsKey(reverseRight) && hm.get(reverseRight) != i) {
                        List<Integer> item = new ArrayList<>();
                        item.add(hm.get(reverseRight));
                        item.add(i);
                        ans.add(item);
                    }
                }
                if (isPalindrome(right)) {
                    String reverseLeft = new StringBuilder(left).reverse().toString();
                    if(hm.containsKey(reverseLeft) && hm.get(reverseLeft) != i && right.length() != 0){
                        //Addition check is right.length() != 0
                        //Or will add duplicate results, like ["abc", "cba"]
                        List<Integer> item = new ArrayList<>();
                        item.add(i);
                        item.add(hm.get(reverseLeft));
                        ans.add(item);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while (l <= r){
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}