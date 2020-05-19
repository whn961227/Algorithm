package com.whn.sort;

public class BubbleSort {
    public void bubbleSort(int[] nums) {
        int len = nums.length;
        int temp;
        int flag;
        for (int i = len - 1; i >= 1; i--) {
            flag = 0;
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = 1;
                }
            }
            if (flag == 0)
                return;
        }
    }
}
