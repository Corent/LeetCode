package com.sven.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm01 {

    private static List<List<String>> lists;
    private static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList(new String[] { "a1", "a2", "a3" });
        List<String> list2 = Arrays.asList(new String[] { "b1", "b2" });
        List<String> list3 = Arrays.asList(new String[] { "c1", "c2", "c3" });

        lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        cartesianProduct(0, new ArrayList<>());
        result.forEach(System.out::println);
    }

    private static void cartesianProduct(int idx, List<String> tmp) {
        if (idx < lists.size() - 1) {
            if (lists.get(idx).size() == 0) {
                cartesianProduct(idx + 1, tmp);
                return;
            }
            for (int i = 0; i < lists.get(idx).size(); i++) {
                List<String> list = new ArrayList<>(tmp);
                list.add(lists.get(idx).get(i));
                cartesianProduct(idx + 1, list);
            }
            return;
        }

        if (lists.get(idx).size() == 0) {
            result.add(tmp);
            return;
        }

        for (int i = 0; i < lists.get(idx).size(); i++) {
            List<String> list = new ArrayList<>(tmp);
            list.add(lists.get(idx).get(i));
            result.add(list);
        }
    }
}