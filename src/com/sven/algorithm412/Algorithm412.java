package com.sven.algorithm412;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algorithm412 {
}

class Solution {
    public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed(1, n).boxed().map(i -> {
            if (i % 3 == 0) {
                return i % 5 == 0? "FizzBuzz" : "Fizz";
            }
            if (i % 5 == 0) return "Buzz";
            return String.valueOf(i);
        }).collect(Collectors.toList());
    }
}