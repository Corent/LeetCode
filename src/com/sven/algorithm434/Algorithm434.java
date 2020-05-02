package com.sven.algorithm434;

public class Algorithm434 {
}

class Solution {
    public int countSegments(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        return s.trim().split("\\s+").length;
    }
}