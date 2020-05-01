package com.sven.Xindongfang;

import java.util.stream.IntStream;

public class Algorithm2 {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 17).forEach(i -> System.out.println(cntInTheLastBasket(i)));
    }

    private static int cntInTheLastBasket(int n) {
        if (n <= 0) return 0;
        int m = 1;
        while (n - m > 0) {
            n -= m;
            m <<= 1;
        }
        return n;
    }
}
