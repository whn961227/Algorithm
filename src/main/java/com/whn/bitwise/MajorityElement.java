package com.whn.bitwise;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        for (Integer num : map.keySet()) {
            Integer count = map.get(num);
            if (count > nums.length / 2)
                return num;
        }
        return -1;
    }
}
