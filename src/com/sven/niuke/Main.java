package com.sven.niuke;

import java.util.Scanner;

public class Main {

    private static int N;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int n = func(nums[0]);
        for (int i = 1; i < N; i++) {
            if (func(nums[i]) != n) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    private static int func(int num) {
        while ((num & 1) == 0) num >>= 1;
        return num;
    }
}


/**
 * te?t*.*
 * txt12.xls
 */
class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p = in.next().toLowerCase();
        String s = in.next().toLowerCase();

        int i = 0, j = 0;
        Integer star = null, rs = null;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
                continue;
            }
            if (j < p.length() && p.charAt(j) == '*') {
                star = j++;
                rs = i;
                continue;
            }
            if (star != null) {
                j = star + 1;
                i = ++rs;
                continue;
            }
            System.out.println(false);
            System.exit(0);
        }
        while (j < p.length() && p.charAt(j) == '*') j++;
        System.out.println(j == p.length());
    }
}