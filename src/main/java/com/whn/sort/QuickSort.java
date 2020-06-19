package com.whn.sort;

public class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        int temp;
        int i = left;
        int j = right;

        if (left < right) {
            temp = nums[left];
            while (i != j) {
                while (j > i && nums[j] >= temp) j--;
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < temp) i++;
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = temp;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }
}
