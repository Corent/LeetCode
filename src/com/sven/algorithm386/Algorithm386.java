package com.sven.algorithm386;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algorithm386 {

    public static void main(String[] args) {
        System.out.println(new Solution2().lexicalOrder(13));
    }
}

class Solution1 {
    public List<Integer> lexicalOrder(int n) {
        return IntStream.rangeClosed(1, n).boxed().map(String::valueOf).sorted().map(Integer::valueOf).collect(Collectors.toList());
    }
}

/**
 * https://www.cnblogs.com/seniusen/p/10607642.html
 */
class Solution2 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        ans.add(num);
        for (int i = 1; i < n; i++) {
            if (num * 10 <= n) num *= 10;
            else {
                while (num % 10 == 9 || num == n) num /= 10;
                num++;
            }
            ans.add(num);
        }
        return ans;
    }
}

/**
 * DFS
 */
class Solution3 {

    private int n;
    private List<Integer> list;

    private void DFS(int num) {
        for (int i = 0; i < 10; i++) {
            int next = num * 10 + i;
            if (next > n)  break;
            list.add(next);
            DFS(next);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        this.list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i <= n) list.add(i);
            if (i * 10 <= n) DFS(i);
        }
        return list;
    }
}