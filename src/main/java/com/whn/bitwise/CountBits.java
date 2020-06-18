package com.whn.bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = Integer.bitCount(i);
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : new CountBits().countBits(2)) {
            System.out.print(i + " ");
        }
    }
}
