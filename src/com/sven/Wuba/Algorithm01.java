package com.sven.Wuba;

public class Algorithm01 {

    public static void main(String[] args) {
        printNums(10);
    }

    public static void printNums(int n) {
        if (n < 0) return;
        if (n == 1 ) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(1);
            System.out.println(1);
        }
        int a = 1, b = 1, idx = 2;
        System.out.println(1);
        System.out.println(1);
        while (idx < n) {
            int next = a + b;
            System.out.println(next);
            a = b;
            b = next;
            idx++;
        }
    }
}
