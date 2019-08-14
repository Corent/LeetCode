package com.sven.algorithm717;

public class Algorithm717 {

    public static void main(String[] args) {
        int[] bits = new int[] { 1, 1, 1, 0 };
        System.out.println(new Solution().isOneBitCharacter(bits));
    }
}

class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) return false;
        int idx = 0;
        while (idx < bits.length) {
            if (idx == bits.length - 1) return bits[idx] == 0;
            else if (bits[idx] == 0) idx++;
            else idx += 2;
        }
        return false;
    }
}

/*class Solution {

    private int[] bits;

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) return false;
        this.bits = bits;
        return isOneBitCharacterCore(0);
    }

    private boolean isOneBitCharacterCore(int idx) {
        if (idx >= bits.length) return false;
        if (idx == bits.length - 1) return bits[idx] == 0;
        while (bits[idx] == 0 && idx < bits.length) idx++;
        if (idx == bits.length) return false;
        return isOneBitCharacterCore(idx + 2);
    }
}*/