package com.whn.bitwise;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int m = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((m & 1) == 1) {
                count++;
            }
            m = m >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
}
