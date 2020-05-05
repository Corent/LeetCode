package com.sven.algorithm476;

public class Algorithm476 {
}

class Solution {
    public int findComplement(int num) {
        return (~num) & ((Integer.highestOneBit(num) << 1) - 1);
    }
}