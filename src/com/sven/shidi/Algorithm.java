package com.sven.shidi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {

    public static void main(String[] args) {

        String[] ans = split("abc,def.ghi", new String[] { "ef", "c" });
        Arrays.stream(ans).forEach(System.out::println);
    }

    public static String[] split(String input, String[] tokens) {
        String[] ans = null;
        for (String token : tokens) {
            if (ans == null) {
                ans = input.split(token);
                continue;
            }
            List<String> list = new ArrayList<>();
            for (String s : ans) Arrays.stream(s.split(token)).forEach(e -> list.add(e));
            ans = new String[list.size()];
            list.toArray(ans);
        }
        return ans;
    }
}