package com.sven.algorithm030;

import java.util.*;

public class Algorithm030 {

    public static void main(String[] args) {
        List<Integer> ans = new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" });
        ans.forEach(an -> System.out.print(an + " "));
    }
}

/**
 * 用个Map存储words中各个词的出现次数，遍历s，依次判断各个词
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null) return ans;
        int sLen = s.length(), wLen = words[0].length(), wsLen = words[0].length() * words.length;
        if (sLen < wsLen) return ans;

        Map<String, Integer> oMap = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            int cnt = oMap.get(word) == null? 0: oMap.get(word);
            oMap.put(word, cnt + 1);
        });
        Map<String, Integer> wMap = new HashMap<>(oMap);

        for (int i = 0; i < sLen - wsLen + 1; i++) {
            boolean flag = true;
            for (int j = i; j < i + wsLen; j += wLen) {
                String tmp = s.substring(j, j + wLen);
                Integer cnt = wMap.get(tmp);
                if (cnt != null) {
                    if (cnt > 0) wMap.put(tmp, cnt - 1);
                    else  {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag && wMap.entrySet().parallelStream().allMatch(entry -> entry.getValue() == 0))
                ans.add(i);
            wMap = new HashMap<>(oMap);
        }

        return ans;
    }
}